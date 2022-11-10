package com.app.warehouse.serviceImpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.warehouse.entity.ShipmentType;
import com.app.warehouse.repo.ShipmentTypeRepo;
import com.app.warehouse.service.IShipmentTypeService;

@Service
public class ShipmentTypeServiceImpl implements IShipmentTypeService {

	@Autowired
	ShipmentTypeRepo repo;
	
	@Transactional
	public Integer saveshipmentType(ShipmentType st) {
		
		Integer id=repo.save(st).getId();
		return id;
	}

}
