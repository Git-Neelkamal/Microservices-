package spring.rest.api.dto;

import lombok.Data;

@Data
public class UserRegisterDto {
	
	
	private String firstName;
	private String lastName;
	private String gender;
	private String password;
	private String city;
	private int dobYear;
	private String email;
	private long mobile;

}
