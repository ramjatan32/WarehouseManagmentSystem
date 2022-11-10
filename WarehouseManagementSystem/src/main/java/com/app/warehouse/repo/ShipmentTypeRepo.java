package com.app.warehouse.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.warehouse.entity.ShipmentType;

public interface ShipmentTypeRepo  extends JpaRepository<ShipmentType, Integer>{

}
