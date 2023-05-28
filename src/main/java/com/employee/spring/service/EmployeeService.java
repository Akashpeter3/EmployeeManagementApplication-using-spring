package com.employee.spring.service;

import java.util.List;

import com.employee.spring.model.Employee;

public interface EmployeeService {

	long save(Employee employee);

	Employee get(long id);

	List<Employee> getAll();

	void update(long id, Employee employee);

	void delete(long id);

	List<Long> saveEmployees(List<Employee> employees);
}
