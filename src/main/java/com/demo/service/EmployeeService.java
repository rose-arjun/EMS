package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.EmployeeDao;
import com.demo.entity.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeDao dao;

	public void saveEmp(Employee emp) {
		dao.saveEmployee(emp);
	}

	public List<Employee> getEmployees() {
	
		return dao.getEmployeeList();
	}

	public void delete(int id) {
		dao.deleteEmploeyee(id);
		
	}

	public void update(int id, Employee emp) {
		dao.update(id,emp);
		
	}

	public Employee getEmployeeData(int id) {
		// TODO Auto-generated method stub
		return dao.get(id);
	}

}
