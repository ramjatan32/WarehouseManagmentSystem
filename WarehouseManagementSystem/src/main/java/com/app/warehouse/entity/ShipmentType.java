package com.app.warehouse.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="shipType")

public class ShipmentType {
	@Id
	@Column(name="id")
	private Integer Id;
	@Column(name="shipMode")
	private String shipmentMode;
	@Column(name="shipCode")
	private String shipmentCode;
	@Column(name="enableshipment")
	private String enableshipment;
	@Column(name="shipmentGrade")
	private String shipmentGrade;
	@Column(name="description")
	private String description;
	
}
