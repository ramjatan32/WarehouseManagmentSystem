package com.app.warehouse.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.app.warehouse.model.Uom;

public interface IUomService {

	
	String saveUom(Uom um);
	void updateUom(Uom um);
	void deleteUom(String id);
	List<Uom> getAllUomList();
	Optional<Uom> getOneUomById(String id);
	boolean isUomExit(String id);
	
	//pagination  work
	Page<Uom>getAllUomListPage(Pageable pageable);
}
