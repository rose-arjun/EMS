package com.demo.controller;

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

import com.demo.entity.Employee;
import com.demo.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@PostMapping("/save")
	public String saveEmployee(@RequestBody Employee emp) {
		service.saveEmp(emp);
		return "Employee saved succesfully";
	}

	@GetMapping("/")
	public ResponseEntity<List<Employee>> getEmp(){
		List<Employee> list = service.getEmployees();
		return ResponseEntity.ok(list);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> delete(@PathVariable int id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/update/{id}")
	public String updateEmployee(@PathVariable int id,@RequestBody Employee emp) {
		service.update(id,emp);
		return "Employee saved succesfully";
	}
	@GetMapping("/{id}")
	public Employee getEmployee(@PathVariable int id) {
		return service.getEmployeeData(id);
	}
}
