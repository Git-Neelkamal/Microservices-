package spring.rest.api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="Amazon_users")
public class UsersData {
	
	@Id
	private String email;
	
	private String firstName;
	private String lastName;
	private String gender;
	private String password;
	private String city;
	private int dobYear;
	private long mobile;
	
	

}
