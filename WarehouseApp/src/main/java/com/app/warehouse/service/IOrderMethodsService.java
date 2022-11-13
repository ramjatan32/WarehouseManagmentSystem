package com.app.warehouse.service;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;

import com.app.warehouse.model.OrderMethods;

public interface IOrderMethodsService {

	String saveOrderMethod(OrderMethods ord);
	void UpdateOrderMethods(OrderMethods ord);
	void deleteOrderMethods(String id);
	List<OrderMethods>getAllOrderMethods();
	Optional<OrderMethods>getOneOrderMethods(String id);
	boolean isExistOrderMethods(String id);
	//
//	Page<OrderMethods>getAllOrderMethodsPage(Pageable pageable);
	
}
