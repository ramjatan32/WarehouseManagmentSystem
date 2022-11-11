package com.app.warehouse.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.warehouse.model.Uom;

public interface IUomRepo extends JpaRepository<Uom, String>{

}
