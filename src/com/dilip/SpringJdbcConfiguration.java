package com.dilip;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@ComponentScan("com.dilip")
@Configuration
public class SpringJdbcConfiguration {
	
	@Bean
	public JdbcTemplate getJdbcTemplate() {
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
		dataSource.setUsername("neelkamal");
		dataSource.setPassword("2502");
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		
	  return new JdbcTemplate(dataSource);
	}
	

}
