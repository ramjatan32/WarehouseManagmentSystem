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

import com.app.warehouse.model.ShipmentType;
import com.app.warehouse.service.IShipmentTypeService;
import com.app.warehouse.view.ShipmentTypeExcel;
import com.app.warehouse.view.ShipmentTypePdf;

@Controller
@RequestMapping("/ship")
public class ShipmentTypeController {

	@Autowired
		private IShipmentTypeService service;
	
	@GetMapping("/show")
	public String showRegisterPage()
	{
		return "ShipmentTypeRegister";
	}
	
	@PostMapping("/save")
	public String saveShipmentType(//read from Data from UI(given by container)
			@ModelAttribute ShipmentType shipmentType,
			Model model //to send data to UI
)
	{
		Integer id=service.saveShipmentType(shipmentType);
		String message="ShipmentType "+id+" Saved successfully";
		model.addAttribute("message", message);
		return "ShipmentTypeRegister";
	}
	
	
	/*
	 * @GetMapping("/all") public String fetchShipmentType(Model model) {
	 * 
	 * List<ShipmentType>list=service.getAllShipmentType();
	 * model.addAttribute("list", list); return "ShipmentTypeData";
	 * 
	 * }
	 */
	@GetMapping("/all")
	public String fetchShipmentTypePage(@PageableDefault(page=0, size=3)Pageable pageable,Model model)
	{
		Page<ShipmentType>page=service.getAllShipmentPage(pageable);
		model.addAttribute("page", page);
		
		return "ShipmentTypeData";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteShipmentType(@PageableDefault(page=0,size=3)Pageable pageable,@PathVariable Integer id,Model model)
	{
		String msg=null;
		if(service.isShipmentTypeExist(id))
		{
			service.deleteShipmentType(id);
			msg="Shipment '"+id+"' Delete Successfully";
		}
		else
		{
			msg="ShipmentType '"+id+"' Not Exist";
		}
		
		model.addAttribute("message", msg);
		Page<ShipmentType>page=service.getAllShipmentPage(pageable);
		model.addAttribute("page", page);
		return "ShipmentTypeData";
	}
	
	@GetMapping("/edit/{id}")
	public String editShipmentType(@PathVariable Integer id, Model model)
	{
		String page=null;
		if(service.isShipmentTypeExist(id))
		{
			Optional<ShipmentType>opt=service.getOneShipmentType(id);
			if(opt.isPresent())
			{
				ShipmentType st=opt.get();
				model.addAttribute("shipmentType", st);
				page="ShipmentTypeEdit";
			}
			else
			{
				page="redirect:../all";
			}
		}
		return page;
	}
	
	@PostMapping("/update")
	public String updateShipmentType(@PageableDefault(page=0,size=3)Pageable pageable,@ModelAttribute ShipmentType shipmentType, Model model)
	{
		service.updateShipmentType(shipmentType);
		String msg="ShipmentType  '"+shipmentType.getId()+"' Update Successfully";
		model.addAttribute("message", msg);
		
		// new Data 
		
		//List<ShipmentType>list=service.getAllShipmentType();
		Page<ShipmentType>page=service.getAllShipmentPage(pageable);
		model.addAttribute("page", page);
		
		return "ShipmentTypeData";
	}
	
	@GetMapping("/view/{id}")
	public String viewShipment(@PathVariable Integer id, Model model)
	{
		
		String page=null;
		if(service.isShipmentTypeExist(id))
		{
			Optional<ShipmentType>opt=service.getOneShipmentType(id);
			if(opt.isPresent())
			{
				ShipmentType ship=opt.get();
				model.addAttribute("ob", ship);
				page="ViewShipmentType";
			}
			else
			{
				page="redirect:../all";
			}
		}
		return page;
	}
	
	@GetMapping("/excel")
	public ModelAndView exportExcel()
	{
		ModelAndView m=new ModelAndView();
		m.setView(new ShipmentTypeExcel());
		// send to data from list
		List<ShipmentType>list=service.getAllShipmentType();
		m.addObject("obs", list);
				return m;
	}
	
	@GetMapping("/excel/{id}")
	public ModelAndView exportExcelOne(@PathVariable Integer id,Model model)
	{
		ModelAndView m=new ModelAndView();
		m.setView(new ShipmentTypeExcel());
		Optional<ShipmentType>opt=service.getOneShipmentType(id);
		if(opt.isPresent())
		{
			m.addObject("obs", Arrays.asList(opt.get()));
		}
		return m;
	}
	
	@GetMapping("/pdf")
	public ModelAndView  exportPdf()
	{
		
		ModelAndView m=new ModelAndView();
		m.setView(new ShipmentTypePdf());
		List<ShipmentType> list=service.getAllShipmentType();
		m.addObject("list", list);
		
		return m;
	}
	
	@GetMapping("/pdf/{id}")
	public ModelAndView exportPdfOne(@PathVariable Integer id,Model model)
	{
		ModelAndView m=new ModelAndView();
		m.setView(new ShipmentTypePdf());
		Optional<ShipmentType>opt=service.getOneShipmentType(id);
		if(opt.isPresent())
		{
			m.addObject("list", Arrays.asList(opt.get()));
		}
		return m;
	}
}
