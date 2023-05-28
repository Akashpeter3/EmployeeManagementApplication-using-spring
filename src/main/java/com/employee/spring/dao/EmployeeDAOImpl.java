package com.employee.spring.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.employee.spring.model.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private SessionFactory sessionFactorty;

	// Save Employee Data
	@Override
	public long save(Employee employee) {
		sessionFactorty.getCurrentSession().save(employee);
		return employee.getEmp_id();
	}

	// getEmployee by id
	@Override
	public Employee get(long id) {
		return sessionFactorty.getCurrentSession().get(Employee.class, id);

	}

	@Override
	public List<Employee> getAll() {
		List<Employee> getAllEmployeeData = sessionFactorty.getCurrentSession().createQuery("from employee").list();
		return getAllEmployeeData;
	}

	@Override
	public void update(long id, Employee employee) {
		Employee oldEmployeeRecord = sessionFactorty.getCurrentSession().get(Employee.class, id);
		oldEmployeeRecord.setEmp_name(employee.getEmp_name());
		oldEmployeeRecord.setEmp_age(employee.getEmp_age());
		sessionFactorty.getCurrentSession().saveOrUpdate(oldEmployeeRecord);

	}

	@Override
	public void delete(long id) {
		Session session = sessionFactorty.getCurrentSession();
		Employee employee = session.byId(Employee.class).load(id);
		session.delete(employee);

	}

	@Override
	public List<Long> saveEmployees(List<Employee> employees) {
		List<Long> empIDList = new ArrayList<Long>();
		for (Employee employee : employees) {
			sessionFactorty.getCurrentSession().save(employee);
			Long id = employee.getEmp_id();
			empIDList.add(id);
		}
		return empIDList;
	}

}
