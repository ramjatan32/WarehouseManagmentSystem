package com.app.warehouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.warehouse.model.OrderMethods;
import com.app.warehouse.service.IOrderMethodsService;

@Controller
@RequestMapping("/order")
public class OrderMethodsController {

	@Autowired
	private IOrderMethodsService service; 
	
	@GetMapping("/show")
	public String showOrderMethodsPage()
	{
		return "OrderMethodsRegister";
	}
	
	@PostMapping("/save")
	public String saveOrderMethod(@ModelAttribute OrderMethods ord, Model model)
	{
		String id=service.saveOrderMethod(ord);
		model.addAttribute("message", "Order Method "+id+" Saved Succesffuly");
		return "OrderMethodsRegister";
	}

	@GetMapping("/all")
	public String FetchAllOrderMethods(Model model)
	{
		List<OrderMethods>list=service.getAllOrderMethods();
		model.addAttribute("list", list);
		return "OrderMethodsData";
	}
	
	@GetMapping("/page")
	public String fetchAllOrderMethodsPage(@PageableDefault(size=0,page=3) Pageable pageable, Model model)
	{
		Page<OrderMethods>page=service.getAllOrderMethodsPage(pageable);
		model.addAttribute("page", page);
		return "OrderMethodsData";
		
	}
}
