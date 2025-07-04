package com.dilip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class EmployyeOperations {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public void addEmployye() {

		jdbcTemplate.update("insert into employee(eid,name,age) VALUES(3,'Suresh',33)");

		jdbcTemplate.update("delete from employee where eid=1");
	}

}
