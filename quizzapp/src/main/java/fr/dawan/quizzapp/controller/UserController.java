package fr.dawan.quizzapp.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.dawan.quizzapp.entities.Users;
import fr.dawan.quizzapp.service.UserService;
@CrossOrigin
@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired 
	private UserService service;
	@GetMapping(produces="application/json")
public List<Users> findAll(){
	return service.findAll();
	
}

	@GetMapping(value = "/{id:[0-9]+}", produces ="application/json")
	
	public ResponseEntity<Users> findUserById(@PathVariable long id)   {
		Users user = service.findUserById(id);
		if (user!= null) {
			return ResponseEntity.ok(user);
		}
		return ResponseEntity.notFound().build();
		
	}
	
	 @PostMapping(value="/save" , produces ="application/json", consumes ="application/json")
	 
	 public Users createUser (@RequestBody Users user) {
		 System.out.println("---------");
		 return service.createUser(user);
	 }
	  @DeleteMapping(value ="/delete/{id:[0-9]+}", produces = MediaType.TEXT_PLAIN_VALUE)
	  public ResponseEntity<String> deleteUserById(@PathVariable long id)   {
			
			 try {
				service.deleteUserById(id);
				return ResponseEntity.ok("User est supprimé");
			} catch (Exception e) {
				return ResponseEntity.notFound().build();
			}
	  }
	  
	  @PutMapping( value ="/update/{id:[0-9]+}",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	  public void updateUser(@RequestBody Users user, @PathVariable long id)
	  {
		  service.updateUserById(user,id);
		  //service.createUser(user);
	  }
}
	
	


