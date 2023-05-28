package com.employee.spring.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.spring.dao.EmployeeDAO;
import com.employee.spring.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO empDAO;

	@Override
	@Transactional
	public long save(Employee employee) {

		return empDAO.save(employee);
	}

	@Override
	@Transactional
	public Employee get(long id) {
		Optional<Employee> optionalValue = Optional.ofNullable(empDAO.get(id));

		if (optionalValue.isPresent()) {
			return optionalValue.get();
		} else {
			Employee employee = new Employee();
			employee.setNoRecord("No employee record found for the id " + id);
			return employee;
		}

	}

	@Override
	@Transactional
	public List<Employee> getAll() {
		return empDAO.getAll();
	}

	@Override
	@Transactional
	public void update(long id, Employee employee) {
		empDAO.update(id, employee);

	}

	@Override
	@Transactional
	public void delete(long id) {
		empDAO.delete(id);

	}

	@Override
	@Transactional
	public List<Long> saveEmployees(List<Employee> employees) {
		
		return empDAO.saveEmployees(employees);
	}

}
