package com.app.warehouse.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.app.warehouse.model.WHUserType;

public interface IWhuUserTypeRepo extends JpaRepository<WHUserType, String> {



}
