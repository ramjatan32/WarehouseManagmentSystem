package com.app.warehouse.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
@Table(name="orderTab")
public class OrderMethods {

	@Id
	@GeneratedValue(generator = "order_method_seq_tab")
	@GenericGenerator(name="order_method_seq_tab", strategy = "com.app.warehouse.generator.OrderMethodsGenerator")
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
