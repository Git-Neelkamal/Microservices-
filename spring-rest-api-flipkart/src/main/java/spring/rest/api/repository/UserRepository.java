package spring.rest.api.repository;

import java.util.List;

import org.apache.catalina.startup.UserDatabase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.rest.api.entity.UsersData;

@Repository
public interface UserRepository extends JpaRepository<UsersData, String>{

	//Custom findBy
	List<UsersData> findByCityAndGender(String city, String gender);

	List<UsersData> findByCity(String city);
	
}
