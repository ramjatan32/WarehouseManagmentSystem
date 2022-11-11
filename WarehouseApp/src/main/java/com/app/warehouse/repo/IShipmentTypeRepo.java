package com.app.warehouse.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.warehouse.model.ShipmentType;

public interface IShipmentTypeRepo extends JpaRepository<ShipmentType, Integer> {

}
