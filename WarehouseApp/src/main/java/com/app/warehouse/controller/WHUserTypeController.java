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

import com.app.warehouse.model.WHUserType;
import com.app.warehouse.service.IWHUserTypeService;
import com.app.warehouse.view.WhUserTypeView;
import com.app.warehouse.view.WhuserTypePdf;

@Controller
@RequestMapping("/whuser")
public class WHUserTypeController {

	@Autowired
	private IWHUserTypeService service;
	
	@GetMapping("/show")
	public String showWhUser()
	{
		return "WhUserTypeRegister";
	}
	
	
	@PostMapping("/save")
	public String saveWhUser(@ModelAttribute WHUserType whuser, Model model)
	{
		String id=service.saveWHUserType(whuser);
		String msg=" WHUser Type  '"+id+"' saved Successfully";
		model.addAttribute("message", msg);
		return "WhUserTypeRegister";
	}
	
	/*@GetMapping("/all")
	public String fetchWhuser(Model model)
	{
		List<WHUserType> list=service.getAllWHUserType();
		model.addAttribute("list", list);
		return "WhuserTypeData";
	}*/
	
	@GetMapping("/all")
	public String fetchWHuserTypepage(@PageableDefault(page=0,size=3)Pageable pageable,Model model)
	{
		Page<WHUserType>page=service.getAllWHUserTypePageForm(pageable);
		model.addAttribute("page", page);
		return "WhuserTypeData";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteWhuser(@PageableDefault(page=0,size=3)Pageable pageable,@PathVariable String id, Model model)
	{
		String msg=null;
		if(service.isWHUserTypeExist(id))
		{
			service.deleteWHUserType(id);
			msg="WhUserType '"+id+"' deleted SuccessFull";
		}
		else
		{
			msg="WhUserType '"+id +"' Not Exist in the Database";
		}
		model.addAttribute("message", msg);
		Page<WHUserType>page=service.getAllWHUserTypePageForm(pageable);
		model.addAttribute("page", page);		
		return "WhuserTypeData" ;
	}
	
	@GetMapping("/edit/{id}")
	public String editWhuser(@PathVariable String id, Model model)
	{
		String page=null;
		if(service.isWHUserTypeExist(id))
		{
			Optional<WHUserType>opt=service.getOneWHUserType(id);
			if(opt.isPresent())
			{
				WHUserType wh=opt.get();
				model.addAttribute("wHUserType", wh);
				page="WhuserTypeEdit";
			}
			else
			{
				page="redirect:../all";
			}
			
		}
		return page;
	}
	
	@PostMapping("/update")
	public String updateWhUserType(@PageableDefault(page=0,size=3)Pageable pageable,@ModelAttribute WHUserType userType,Model model)
	{
		String smg=null;
		service.updateWHUserType(userType);
		smg="WHUserType '"+userType.getId()+"' Update Successfull";
		model.addAttribute("message", smg);
		
		Page<WHUserType>page=service.getAllWHUserTypePageForm(pageable);
		model.addAttribute("page", page);
		return "WhuserTypeData";
	}
	
	@GetMapping("/view/{id}")
	public String viewWhUserType(@PathVariable String id, Model model)
	{
		String page=null;
		if(service.isWHUserTypeExist(id))
		{
			Optional<WHUserType>opt=service.getOneWHUserType(id);
			if(opt.isPresent())
			{
				WHUserType wh=opt.get();
				model.addAttribute("ob", wh);
				page="whuserTypeview";
			}
		}
		else
		{
			page="redirect:../all";
		}
		return page;
	}
	
	@GetMapping("/excel")
	public ModelAndView exportExcel()
	{
		ModelAndView m=new ModelAndView();
		m.setView(new WhUserTypeView());
		List<WHUserType>list=service.getAllWHUserType();
		m.addObject("obs", list);
		return m;
	
	}
	
	@GetMapping("/excel/{id}")
	public ModelAndView exportExcelOne(@PathVariable String id,Model model)
	{
		ModelAndView m=new ModelAndView();
		m.setView(new WhUserTypeView());
		Optional<WHUserType>opt=service.getOneWHUserType(id);
		if(opt.isPresent())
		{
			m.addObject("obs", Arrays.asList(opt.get()));
		}
		return  m;
	}
	
	@GetMapping("/pdf")
	public ModelAndView exportPdf()
	{
		ModelAndView m=new ModelAndView();
		m.setView(new WhuserTypePdf());
		
		List<WHUserType>list=service.getAllWHUserType();
		m.addObject("list", list);
		return m;
	}
	
	@GetMapping("/pdf/{id}")
	public ModelAndView exportPdfOne(@PathVariable String id,Model model)
	{
		ModelAndView m=new ModelAndView();
		m.setView(new WhuserTypePdf());
		Optional<WHUserType>opt=service.getOneWHUserType(id);
		if(opt.isPresent())
		{
			m.addObject("list", Arrays.asList(opt.get()));
		}
		return m;
	}
}
