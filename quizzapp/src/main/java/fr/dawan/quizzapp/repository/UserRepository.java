package fr.dawan.quizzapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.dawan.quizzapp.entities.Users;
@Repository
public interface UserRepository extends JpaRepository<Users, Long>{
	
	//SELECT * FROM USERS WHERE ROLE=ADMIN
	//@Query (value = "insert into Users (user_id) VALUES (:insertLink,:id)", nativeQuery = true)
	//Users saveOrUpdate(Users user);
		
	
}
