package com.app.warehouse.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="ship_table")
public class ShipmentType { 

	
	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer Id;
	@Column(name="shipmentMode")
	private String shipmentMode;
	@Column(name="shipmentCode")
	private String shipmentCode;
	@Column(name="enableShipment")
	private String enableShipment; 
	@Column(name="description")
	private String description;
}
