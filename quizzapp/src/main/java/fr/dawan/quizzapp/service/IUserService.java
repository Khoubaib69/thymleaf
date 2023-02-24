package fr.dawan.quizzapp.service;

import java.util.List;

import fr.dawan.quizzapp.entities.Users;

public interface IUserService {
	List<Users> findAll();
	Users createUser( Users user); 
	Users findUserById(Long id);
	void deleteUserById(Long id);
	Users updateUserById(Users user,long id);

}
