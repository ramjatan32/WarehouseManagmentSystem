package com.app.warehouse.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.app.warehouse.model.ShipmentType;

public interface IShipmentTypeService {

	Integer saveShipmentType(ShipmentType st);
	void updateShipmentType(ShipmentType st);
	void deleteShipmentType(Integer id);
	List<ShipmentType> getAllShipmentType();
	Optional<ShipmentType> getOneShipmentType(Integer id);
	boolean isShipmentTypeExist(Integer id);
	
	// pagination code
	Page<ShipmentType>getAllShipmentPage(Pageable pageable);
}
