package com.dilip;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringJDbcDemo {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		context.register(SpringJdbcConfiguration.class);
		context.refresh();

		EmployyeOperations ops = context.getBean(EmployyeOperations.class);
		
		ops.addEmployye();

	}

}
