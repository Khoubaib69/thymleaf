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

import fr.dawan.quizzapp.entities.Quizz;
import fr.dawan.quizzapp.entities.QuizzTest;
import fr.dawan.quizzapp.service.IQuizzTestService;
@CrossOrigin
@RestController
@RequestMapping("/api/quizztest")
public class QuizzTestController {
	@Autowired 
	private IQuizzTestService service;
	
	
	@GetMapping(produces="application/json")
	public List<QuizzTest> findAll(){
	return service.findAll();
	}
	
	@GetMapping(value = "/{id:[0-9]+}", produces ="application/json")
	
	public ResponseEntity<QuizzTest> findQuizzById(@PathVariable long id)   {
		QuizzTest q = service.findById(id);
		if (q != null)
		{return ResponseEntity.ok(q);}
		return ResponseEntity.notFound().build();	
	}
	
	@PostMapping(produces ="application/json", consumes ="application/json")
	 public QuizzTest createQuizzTest (@RequestBody QuizzTest quizzTest) {
		 return service.createQuizzTest(quizzTest);
	 }
	
	@DeleteMapping(value ="/delete/{id:[0-9]+}", produces = MediaType.TEXT_PLAIN_VALUE)
 	public ResponseEntity<String> deleteQuizzTestById(@PathVariable long id)   {
		
		 try {
			service.deleteQuizzTestById(id);
			return ResponseEntity.ok("Quizz test est bien supprimé");
		} catch (Exception e) {
			return ResponseEntity.notFound().build();	
		}
 		}
 	 @PutMapping( value ="/update/{id:[0-9]+}",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	  public void updateQuizzTest(@RequestBody QuizzTest quizztest, @PathVariable long id)
	  {
		  service.updateQuizzTestById(quizztest,id);
		  //service.createUser(user);
	  }

}
