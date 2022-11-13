package com.app.warehouse.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="orderTab")
public class OrderMethods {

	@Id
	@Column(name="id")
	private String id;
	@Column(name="ordrMode")
	private String orderMode;
	@Column(name="ordrCode")
	private String orderCode;
	@Column(name="ordrType")
	private String orderType;
	@Column(name="ordrAcept")
	private String orderAcept;
	@Column(name="description")
	private String description;
}
