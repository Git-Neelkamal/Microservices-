package spring.rest.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import spring.rest.api.dto.MoreUsersInformation;
import spring.rest.api.dto.UserRegisterDto;
import spring.rest.api.dto.UserRegisterDto2;
import spring.rest.api.entity.UsersData;
import spring.rest.api.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService service;
	
	
	
	
	
	//post
	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody UserRegisterDto request) {
		
		System.out.println(request);
		
		if (request.getEmail()==null) {
			
			ResponseEntity<String> responseEntity= new ResponseEntity<>("EmailId is missing", HttpStatus.BAD_REQUEST);
			return responseEntity;
		}
		
		String result=	service.registerUser(request);
		
		if(result.equalsIgnoreCase(service.EMAIL_EXISTS)) {
			return new ResponseEntity<>(result, HttpStatus.OK);
		}
		else if (result.equalsIgnoreCase(service.USER_CREATED)) {
			return new ResponseEntity<>("user created", HttpStatus.CREATED);
		}
		return new ResponseEntity<>(" For queries contavt info@gmail.com", HttpStatus.BAD_REQUEST);
	}
	
	
	
	@PostMapping("/register/many")
	public String registerManyUsers(@RequestBody List<UserRegisterDto> users) {
		
		
		users.forEach(System.out::println);
		
		//String result=	service.registerManyUsers(users);
		
		return "user Registered Successfully";
	}
	
	
	@PostMapping("/register/many/v2")
	public String registerManyUsers(@RequestBody MoreUsersInformation users) {
		
		//users.getUsers().forEach(System.out::println);
		users.getAddress().forEach(System.out::println);
		
		//String result=	service.registerManyUsers(users);
		
		return "user Registered Successfully";
	}
	

	
	@PostMapping("/v2/register")
	public String registerUserWithAddress(@RequestBody UserRegisterDto2 request) {
		
		System.out.println(request);
		System.out.println(request.getAddress());
		
		
		return "user Registered Successfully";
	}
	
	
	
	@DeleteMapping("/remove/{email}")
	public ResponseEntity<String> deleteUser(@PathVariable String email) {
		
		
		
		return new ResponseEntity<>(service.removeUser(email),HttpStatus.OK);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@GetMapping("/load")
	public UserRegisterDto loadAllUsers( ) {
		
		
		
		return new UserRegisterDto();
	}
	

	@GetMapping("/{emailId}")
	public UsersData getUserInformation(@PathVariable("emailId") String email) {
		
		System.out.println(email);
		
		return service.getUserInfo(email);
	}
	
	

	@GetMapping("/city/{city}/gender/{gender}")
	public List<UsersData> getUserInformationByCityAndGender(@PathVariable("city") String city,@PathVariable("gender") String gender) {
		
		System.out.println("mail id id"+gender);
		System.out.println("city is "+city);
		
		return service.getUserInfoByCityAndGender(city,gender);
	}
	
	

	@GetMapping("/city")
	public List<UsersData> getUserInformationByCity(@RequestParam("city") String city) {
		
		System.out.println("city is "+city);
		
		return service.getUserInfoByCity(city);
	}
	@GetMapping("/get")
	public List<UsersData> getUserInfoByCityAndGender(@RequestParam("city") String city,@RequestParam("gender") String gender) {
		
		System.out.println("mail id id"+gender);
		System.out.println("city is "+city);
		
		return service.getUserInfoByCityAndGender(city,gender);
	}
}
