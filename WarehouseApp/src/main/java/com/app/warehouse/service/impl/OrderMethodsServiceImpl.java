package com.app.warehouse.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.warehouse.model.OrderMethods;
import com.app.warehouse.repo.IOrderMethodsRepo;
import com.app.warehouse.service.IOrderMethodsService;

@Service
public class OrderMethodsServiceImpl implements IOrderMethodsService{

	@Autowired
	private IOrderMethodsRepo repo;
	@Transactional()
	public String saveOrderMethod(OrderMethods ord) {
		return repo.save(ord).getId();
	}

	@Transactional
	public void UpdateOrderMethods(OrderMethods ord) {
			repo.save(ord);
	}

		@Transactional
	public void deleteOrderMethods(String id) {
					repo.deleteById(id);
				}

	@Transactional(readOnly = true)
	public List<OrderMethods> getAllOrderMethods() {
			List<OrderMethods>list=repo.findAll();
		return list;
	}

	@Transactional(readOnly = true)
	public Optional<OrderMethods> getOneOrderMethods(String id) {
						Optional<OrderMethods>opt=repo.findById(id);
		return opt;
	}

	@Transactional(readOnly = true)
	public boolean isExistOrderMethods(String id) {
		return repo.existsById(id);
	}

	@Transactional(readOnly = true)
	public Page<OrderMethods> getAllOrderMethodsPage(Pageable pageable) {
			
			//Page<OrderMethods>page= repo.findAll(pageable);
		return null;
	}

	
	

}
