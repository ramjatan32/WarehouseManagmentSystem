package com.app.warehouse.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.warehouse.model.WHUserType;
import com.app.warehouse.repo.IWhuUserTypeRepo;
import com.app.warehouse.service.IWHUserTypeService;

@Service
public class WHUserTypeServiceImpl implements IWHUserTypeService{

	@Autowired
	private IWhuUserTypeRepo repo;
	
	@Transactional
	public String saveWHUserType(WHUserType whuser) {
			String id=repo.save(whuser).getId();
		return id;
	}

	@Transactional
	public void updateWHUserType(WHUserType whuser) {
		repo.save(whuser);
	}

	@Transactional
	public void deleteWHUserType(String id) {
			repo.deleteById(id);
	}

	@Transactional(readOnly = true)
	public List<WHUserType> getAllWHUserType() {
			List<WHUserType>list=repo.findAll();
		return list;
	}

	@Transactional(readOnly = true)
	public Optional<WHUserType> getOneWHUserType(String id) {
			Optional<WHUserType>opt=repo.findById(id);
		return opt;
	}

	@Transactional(readOnly = true)
	public boolean isWHUserTypeExist(String id) {
			boolean exit=repo.existsById(id);
		return exit;
	}

	@Transactional(readOnly = true)
	public Page<WHUserType> getAllWHUserTypePageForm(Pageable pageable) {
			Page<WHUserType>page=repo.findAll(pageable);
		return page;
	}


}
