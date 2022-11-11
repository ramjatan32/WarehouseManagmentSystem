package com.app.warehouse.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.warehouse.model.Uom;
import com.app.warehouse.service.IUomService;
import com.app.warehouse.view.UomExcelView;
import com.app.warehouse.view.UomPdfView;

@Controller
@RequestMapping("/uom")
public class UomController {

	
	@Autowired
	private IUomService service;
	
	@GetMapping("/show")
	public String showUomRegister()
	{
		return "UomRegister";
	}
	
	
	@PostMapping("/save")
	public String SaveUom(@ModelAttribute Uom um, Model model)
	{
		String id=service.saveUom(um);
		String msg="Uom '"+id+"' saved Successfully";
		model.addAttribute("message", msg);
		return "UomRegister";
	}
	
	/*
	 * @GetMapping("/all") public String fetchUom(Model model) {
	 * List<Uom>list=service.getAllUomList(); model.addAttribute("list", list);
	 * return "UomListData"; }
	 */
	
	@GetMapping("/all")
	public String fetchPageUom(@PageableDefault(page=0,size=3) Pageable pageable,Model model)
	{
		Page<Uom>page=service.getAllUomListPage(pageable);
		model.addAttribute("page", page);
		return "UomListData";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteUom(@PageableDefault(page=0,size=3)Pageable pageable,@PathVariable String id,Model model)
	{
		String msg=null;
		if(service.isUomExit(id))
		{
			service.deleteUom(id);
			msg="Uom '"+id+"' Deleted Success";
		}
		else
		{
			msg=" Uom '"+id+"' Not Exist in Data Base";
		}
		model.addAttribute("message", msg);
		Page<Uom>page=service.getAllUomListPage(pageable);
		model.addAttribute("page", page);
		return "UomListData";
	}
	
	@GetMapping("/edit/{id}")
	public String editUom(@PathVariable String id,Model model)
	{
		String page=null;
		if(service.isUomExit(id))
		{
			Optional<Uom>opt=service.getOneUomById(id);
			if(opt.isPresent())
			{
				Uom um=opt.get();
				model.addAttribute("uom", um);
				page="UomEdit";
			}
			else
			{
				page="redirect:../all";
			}
		}
		return page;
	}
	
	
	@PostMapping("/update")
	public String updateUom(@PageableDefault(page=0,size=3)Pageable pageable, @ModelAttribute Uom uom, Model model)
	{
		service.updateUom(uom);
		String msg=" Uom '"+uom.getId()+"' Update Successfully";
		model.addAttribute("message", msg);
		
		// new Data show in the database
		
		//List<Uom>list=service.getAllUomList(pageable);
		Page<Uom>page=service.getAllUomListPage(pageable);
		model.addAttribute("page", page);
		return "UomListData";
	}
	
	@GetMapping("/view/{id}")
	public String viewUom(@PathVariable String id,Model model) {
		
		String page=null;
		if(service.isUomExit(id))
		{
				Optional<Uom>opt=service.getOneUomById(id);
				if(opt.isPresent())
				{
					Uom um=opt.get();
					model.addAttribute("ob", um);
					page="UomView";
				}
				else
				{
					page="redirect:../all";
				}
		}
		return page;
	}
	
	@GetMapping("/excel")
	public ModelAndView uomView()
	{
		ModelAndView mv=new ModelAndView();
		mv.setView(new UomExcelView());
		List<Uom>list=service.getAllUomList();
		mv.addObject("obs", list);
		return mv;
	}
	
	@GetMapping("/excel/{id}")
	public ModelAndView exportExcelUom(@PathVariable String id,Model model)
	{
		ModelAndView m=new ModelAndView();
		m.setView(new UomExcelView());
		
		Optional<Uom>opt=service.getOneUomById(id);
		if(opt.isPresent())
		{
			m.addObject("obs", Arrays.asList(opt.get()));
		}
		return m;
	}
	
	@GetMapping("/pdf")
	public ModelAndView exportPdf()
	{
		ModelAndView m=new ModelAndView();
		m.setView(new UomPdfView());

		List<Uom>list=service.getAllUomList();
		m.addObject("list", list);
		return m;
	}
	
	@GetMapping("/pdf/{id}")
	public ModelAndView exportPdfOne(@PathVariable String id,Model model)
	{
		ModelAndView m=new ModelAndView();
		m.setView(new UomPdfView());
		Optional<Uom>opt=service.getOneUomById(id);
		if(opt.isPresent())
		{
			m.addObject("list", Arrays.asList(opt.get()));
		}
		return m;
	}
}
