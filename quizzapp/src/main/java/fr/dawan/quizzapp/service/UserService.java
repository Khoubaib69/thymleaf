package fr.dawan.quizzapp.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dawan.quizzapp.entities.Users;
import fr.dawan.quizzapp.repository.UserRepository;
@Service
@Transactional
public class UserService implements IUserService{
@Autowired
private UserRepository uRepository;


	@Override
	public List<Users> findAll() {
		// TODO Auto-generated method stub
		return uRepository.findAll();
	}

	@Override
	public Users createUser(Users user) {
		// TODO Auto-generated method stub
		return uRepository.save(user);
	}


	@Override
	public Users findUserById(Long id) {
		Optional<Users> user = uRepository.findById(id);
		if (user.isPresent())
		{return user.get();}
		
		return null;
	}

	@Override
	public void deleteUserById(Long id) {
		 uRepository.deleteById(id);
		
	}

	@Override
	public Users updateUserById(Users user, long id) {
		//Users user =findUserById(id);
		if (user!= null) {
			user.setUserId(id);
			return uRepository.saveAndFlush(user);
		}
		return null;
	}


	
	

}
