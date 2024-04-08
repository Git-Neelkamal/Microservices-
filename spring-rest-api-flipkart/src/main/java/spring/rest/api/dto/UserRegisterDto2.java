package spring.rest.api.dto;

import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails.Address;

import lombok.Data;

@Data
public class UserRegisterDto2 {
	
	
	private String firstName;
	private String lastName;
	private String gender;
	private String password;
	private String city;
	private int dobYear;
	private String email;
	private long mobile;
	private AddressDetails address;

}
