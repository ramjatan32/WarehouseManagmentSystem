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
@Table(name="Uom_Table")
public class Uom {

	@Id
	
	@GeneratedValue(generator = "uom_type_seq_name")
	@GenericGenerator(name="uom_type_seq_name",strategy = "com.app.warehouse.generator.UomTypeGen")
	@Column(name="id")
	private String Id;
	@Column(name="uomtype")
	private String uomType;
	@Column(name="uommodel")
	private String uomModel;
	@Column(name="description")
	private String Description;
	
}
