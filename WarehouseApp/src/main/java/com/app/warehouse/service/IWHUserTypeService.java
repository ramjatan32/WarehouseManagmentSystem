package com.app.warehouse.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.app.warehouse.model.WHUserType;

public interface IWHUserTypeService {

	
	String saveWHUserType(WHUserType whuser);
	void updateWHUserType(WHUserType whuser);
	void deleteWHUserType(String id);
	List<WHUserType>getAllWHUserType();
	Optional<WHUserType>getOneWHUserType(String id);
	boolean isWHUserTypeExist(String id);
	
	// pagination code
	Page<WHUserType>getAllWHUserTypePageForm(Pageable pageable);
	
}
