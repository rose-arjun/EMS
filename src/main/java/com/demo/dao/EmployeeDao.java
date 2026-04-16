package com.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.entity.Employee;

@Repository
public class EmployeeDao {

	@Autowired
	private JdbcTemplate template;

	public void saveEmployee(Employee emp) {
		String insertQuery="Insert into employee (ename,designation,dept) values (?,?,?)";
		template.update(insertQuery,emp.getEname(),emp.getDesignation(),emp.getDept());
	}

	public List<Employee> getEmployeeList() {
		String query="select * from employee";

		return template.query(query,new BeanPropertyRowMapper<>(Employee.class));
	}

	public void deleteEmploeyee(int id) {
		String delQuery="delete from employee where id=?";

		template.update(delQuery,id);
	}

	public void update(int id, Employee emp) {
		String update="UPDATE employee SET ename=?, designation=?, dept=? WHERE id=?";
		template.update(update,emp.getEname(),emp.getDesignation(),emp.getDept(),id);

	}

	public Employee get(int id) {
		String query="select * from employee where id=?";

		 try {
		        return template.queryForObject(
		                query,
		                new BeanPropertyRowMapper<>(Employee.class),
		                id
		        );
		    } catch (EmptyResultDataAccessException e) {
		        return null; // if no record found
		    }
	}

}
