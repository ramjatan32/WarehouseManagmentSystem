package com.app.warehouse.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.warehouse.model.Uom;
import com.app.warehouse.repo.IUomRepo;
import com.app.warehouse.service.IUomService;

@Service
public class UomServiceImpl implements IUomService{

	
	@Autowired
	private IUomRepo repo;
	
	@Transactional
	public String saveUom(Uom um) {
	
		return repo.save(um).getId();
	}

	@Transactional
	public void updateUom(Uom um) {
			repo.save(um);
	}

	@Transactional
	public void deleteUom(String id) {
			repo.deleteById(id);
	}

	@Transactional(readOnly = true)
	public List<Uom> getAllUomList() {
			List<Uom>list=repo.findAll();
		return list;
	}

	@Transactional(readOnly = true)
	public Optional<Uom> getOneUomById(String id) {
			Optional<Uom>opt=repo.findById(id);
		return opt;
	}

	@Transactional(readOnly = true)
	public boolean isUomExit(String id) {
		boolean exit=repo.existsById(id);
		return exit;
	}

	

	@Transactional(readOnly = true)
	public Page<Uom> getAllUomListPage(Pageable pageable) {
		return repo.findAll(pageable);
	}
}
