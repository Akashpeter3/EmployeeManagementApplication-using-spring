package com.employee.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.spring.model.Employee;
import com.employee.spring.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	// save employee to db
	@PostMapping("/api/saveEmployee")
	ResponseEntity<?> saveEmployee(@RequestBody Employee employee) {
		long empID = employeeService.save(employee);
		return ResponseEntity.ok().body(empID);

	}

	//Save lots of employess
	@PostMapping("/api/saveEmployees")
	ResponseEntity<?> saveEmployees(@RequestBody List<Employee> employee) {
		List<Long> empIDList = employeeService.saveEmployees(employee);
		return ResponseEntity.ok().body(empIDList);

	}

	// get all employees from db
	@GetMapping("/api/getAllEmployeeData")
	ResponseEntity<List<Employee>> getAllEmployeeData() {
		List<Employee> allEmployees = employeeService.getAll();
		return ResponseEntity.ok().body(allEmployees);

	}

	// get an imployee with id
	@GetMapping("/api/getEmployeeByID/{id}")
	ResponseEntity<?> getEmployeeByID(@PathVariable("id") long id) {
		Employee employee = employeeService.get(id);
		if (employee.getNoRecord() != null) {
			return ResponseEntity.ok().body(employee.getNoRecord());
		}
		return ResponseEntity.ok().body(employee);

	}

	// update employee name and age with id
	@PutMapping("/api/updateEmployeeRecord/{id}")
	ResponseEntity<?> updateEmployeeRecord(@PathVariable("id") long id, @RequestBody Employee employee) {
		employeeService.update(id, employee);
		return ResponseEntity.ok().body("Employee record updated for the id " + id);

	}

	// delete an employee with id
	@DeleteMapping("/api/deleteEmployee/{id}")
	ResponseEntity<?> deleteEmployee(@PathVariable("id") long id) {
		employeeService.delete(id);
		return ResponseEntity.ok().body("Employee record deleted for the id " + id);

	}

}
