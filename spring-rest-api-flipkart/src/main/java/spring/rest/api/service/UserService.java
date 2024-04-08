package spring.rest.api.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import spring.rest.api.dto.UserRegisterDto;
import spring.rest.api.dto.UserRegisterDto2;
import spring.rest.api.entity.UsersData;
import spring.rest.api.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	
	UserRepository repository;
	

	public final String EMAIL_EXISTS="Email already used, olease try with different email";
	public final String USER_CREATED="USER CREATED SUCCESSFULLY";
	

	public String registerUser(UserRegisterDto request) {
		
		UsersData usersData= new UsersData();
		usersData.setEmail(request.getEmail());
		usersData.setFirstName(request.getFirstName());
		usersData.setLastName(request.getLastName());
		usersData.setGender(request.getGender());
		usersData.setDobYear(request.getDobYear());
		usersData.setMobile(request.getMobile());
		usersData.setPassword(request.getPassword());
		usersData.setCity(request.getCity());
		Optional<UsersData> user = repository.findById(request.getEmail());
		
		if(user.isPresent()) {
			
			return EMAIL_EXISTS;
		}
		
		
		
		
		
		
		repository.save(usersData);
		
		return USER_CREATED;
		// TODO Auto-generated method stub
		
		
	}

	public UsersData getUserInfo(String email) {

		
		
		return repository.findById(email).get();
	}

	public List<UsersData> getUserInfoByCityAndGender(String city, String gender) {
		// TODO Auto-generated method stub
		return repository.findByCityAndGender(city, gender);
	}

	public List<UsersData> getUserInfoByCity(String city) {
			
		return repository.findByCity(city);
	}

	public String removeUser(String email) {

		repository.deleteById(email);
		
		
		return "user removed";
	}

	



	
}
