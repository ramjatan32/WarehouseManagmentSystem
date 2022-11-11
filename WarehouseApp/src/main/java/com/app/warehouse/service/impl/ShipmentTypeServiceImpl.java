package com.app.warehouse.service.impl;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import com.app.warehouse.model.ShipmentType;
import com.app.warehouse.repo.IShipmentTypeRepo;
import com.app.warehouse.service.IShipmentTypeService;

@Service
public class ShipmentTypeServiceImpl  implements IShipmentTypeService{

	@Autowired
	private IShipmentTypeRepo repo;
	
	@Transactional
	public Integer saveShipmentType(ShipmentType st) {
		return repo.save(st).getId();
	}

	@Transactional
	public void updateShipmentType(ShipmentType st) {
		repo.save(st);
	}

	@Transactional
	public void deleteShipmentType(Integer id) {
			repo.deleteById(id);
			
	}

	@Transactional(readOnly = true)
	public List<ShipmentType> getAllShipmentType() {
			List<ShipmentType>list=repo.findAll();
		return list;
	}

	@Transactional(readOnly = true)
	public Optional<ShipmentType> getOneShipmentType(Integer id) {
		Optional<ShipmentType>op=repo.findById(id);
		return op;
	}

	@Transactional(readOnly = true)
	public boolean isShipmentTypeExist(Integer id) {
			boolean exit=repo.existsById(id);
		return exit;
	}

	@Transactional(readOnly = true)
	public Page<ShipmentType> getAllShipmentPage(Pageable pageable) {
		
		return repo.findAll(pageable);
	}

}
