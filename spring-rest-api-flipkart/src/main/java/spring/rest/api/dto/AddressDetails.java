package spring.rest.api.dto;

import lombok.Data;

@Data
public class AddressDetails {
	
	private String city;
	private String state;
	private String country;
	private int pincode;

}
