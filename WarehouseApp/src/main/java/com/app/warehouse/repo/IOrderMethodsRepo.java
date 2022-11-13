package com.app.warehouse.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.warehouse.model.OrderMethods;

public interface IOrderMethodsRepo extends JpaRepository<OrderMethods, String> {

}
