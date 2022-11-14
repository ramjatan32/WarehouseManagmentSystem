package com.app.warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
	
}
