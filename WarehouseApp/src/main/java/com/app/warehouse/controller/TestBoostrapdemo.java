package com.app.warehouse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestBoostrapdemo {

	@GetMapping("/show")
	public String showPage()
	{
		return "TestBootstrap";
	}
}
