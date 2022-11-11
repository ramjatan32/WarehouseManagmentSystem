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
@Table(name="WhUserType")
public class WHUserType {

	@Id
	@GeneratedValue(generator = "wh_user_Type")
	@GenericGenerator(name="wh_user_Type",strategy = "com.app.warehouse.generator.WhUserGenerator")
	@Column(name="id")
	private String Id;
	@Column(name="userType")
	private String userType;
	@Column(name="usercode")
	private String userCode;
	@Column(name="userfor")
	private String userFor;
	@Column(name="userEmail")
	private String userEmail;
	@Column(name="usercontact")
	private String userContact;
	@Column(name="useridtype")
	private String userIdType;
	@Column(name="ifother")
	private String ifOther;
	@Column(name="idnumber")
	private String idNumber; 
}
