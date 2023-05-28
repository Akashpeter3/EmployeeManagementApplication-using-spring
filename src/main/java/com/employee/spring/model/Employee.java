package com.employee.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreType;

@Entity(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long emp_id;
	private String emp_name;
	private int emp_age;
	private Long emp_contact;
	@Transient
	@JsonIgnore
	private String noRecord;

	public Long getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(Long emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public int getEmp_age() {
		return emp_age;
	}

	public void setEmp_age(int emp_age) {
		this.emp_age = emp_age;
	}

	public Long getContact() {
		return emp_contact;
	}

	public void setContact(Long contact) {
		this.emp_contact = contact;
	}

	public String getNoRecord() {
		return noRecord;
	}

	public void setNoRecord(String noRecord) {
		this.noRecord = noRecord;
	}

	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", emp_name=" + emp_name + ", emp_age=" + emp_age + ", contact="
				+ emp_contact + "]";
	}

}
