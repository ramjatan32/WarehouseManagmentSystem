package com.app.warehouse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
public class OrderMethodsController {

	@GetMapping("/show")
	public String showOrderMethodsPage()
	{
		return "OrderMethodsRegister";
	}
}
