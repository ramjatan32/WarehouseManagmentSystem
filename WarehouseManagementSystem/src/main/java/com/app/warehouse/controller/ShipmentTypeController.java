package com.app.warehouse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/ship")
public class ShipmentTypeController {

	
	/*
	 * @Autowired private IShipmentTypeService service;
	 */
	@GetMapping("/show")
	public String showShipmentType()
	{
		
		return "ShipmentTypeRegister";
	}
}
