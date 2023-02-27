package fr.dawan.quizzapp.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dawan.quizzapp.dtos.DtoTools;
import fr.dawan.quizzapp.dtos.LoginDto;
import fr.dawan.quizzapp.dtos.LoginResponseDto;
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

public LoginResponseDto CheckLogin(LoginDto loginDto) throws Exception {
		
		System.out.println(loginDto.getEmail());
		
		Users user = uRepository.findByEmail(loginDto.getEmail());
		if(user != null && user.getPassword().equals(loginDto.getPassword())) {	
			
//			ModelMapper mapper = new ModelMapper();
//			mapper.map(user,  LoginResponseDTO.class);
			
			//Convertir user (entity) en loginResponseDto (DTO) en utilisant ModelMapper
			LoginResponseDto loginResponseDTO  = DtoTools.Convert(user, LoginResponseDto.class);
			
//			//Gestion du token
//			
//			//- choisir les infos du user a sauvegarder
//			Map<String, Object> claims = new HashMap<>();
//			claims.put("userId", user.getId());
//			claims.put("fullname", user.getFirstName()+" "+user.getLastName());
//			
//			//Générer le token
//			String token = jwtTokenTool.doGenerateToken(claims, user.getEmail());
//			
//			//Sauvegarde du token dans la map qu'utilise l'API pout vérifier le token
//			TokenSaver.tokenByEmail.put(user.getEmail(), token);
//			
//			//Injection du token loginResponseDTO
//			loginResponseDTO.setToken(token);
//			
			
			return loginResponseDTO;
		}else {
			throw new Exception("Echec connexion.");
		}
		
		
	}
	
	

}
