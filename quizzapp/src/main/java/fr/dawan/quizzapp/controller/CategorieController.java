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

import fr.dawan.quizzapp.entities.Categorie;
import fr.dawan.quizzapp.entities.Quizz;
import fr.dawan.quizzapp.service.ICategorieService;

@CrossOrigin
@RestController
@RequestMapping("/api/categorie")
public class CategorieController {
	@Autowired 
	private ICategorieService service;
	
	@GetMapping(produces="application/json")
	public List<Categorie> findAll(){
	return service.findAll();
	}
	
	@GetMapping(value = "/{id:[0-9]+}", produces ="application/json")
	
	public ResponseEntity<Categorie> findCategorieById(@PathVariable long id)   {
		
	//return service.findById(id);
		Categorie c = service.findById(id);
		if (c!=null)
			return ResponseEntity.ok(c) ;
		else 
			return ResponseEntity.notFound().build();
	}
	@PostMapping(produces ="application/json", consumes ="application/json")
	 public Categorie createQuizz (@RequestBody Categorie categorie) {
		 return service.createCategorie(categorie);
	 }
	@DeleteMapping(value ="/delete/{id:[0-9]+}", produces = MediaType.TEXT_PLAIN_VALUE)
 	public ResponseEntity<String>deleteCategorieById(@PathVariable long id)   {
		
		 try {
			service.deleteCategorieById(id);
			return ResponseEntity.ok("Categorie supprimée");
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
			
		}
 		}
	 @PutMapping( value ="/update/{id:[0-9]+}",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	  public void updateUser(@RequestBody Categorie categorie, @PathVariable long id)
	  {
		  service.updateCategorieById(categorie,id);
		  //service.createUser(user);
	  }
}
