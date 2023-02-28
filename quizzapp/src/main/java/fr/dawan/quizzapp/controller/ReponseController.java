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

import fr.dawan.quizzapp.entities.Question;
import fr.dawan.quizzapp.entities.Quizz;
import fr.dawan.quizzapp.entities.Reponse;
import fr.dawan.quizzapp.service.IQuestionService;
import fr.dawan.quizzapp.service.IReponseService;
@CrossOrigin
@RestController
@RequestMapping("/api/reponse")
public class ReponseController {
	@Autowired 
	private IReponseService service;
	@Autowired 
	private IQuestionService qservice;
	@GetMapping(produces="application/json")
	public List<Reponse> findAll(){
	return service.findAll();
	}
	
	@GetMapping(value = "/{id:[0-9]+}", produces ="application/json")
	
	public ResponseEntity<Reponse> findReponseById(@PathVariable long id)   {
		Reponse r= service.findById(id);
		if (r!=null) {
			return ResponseEntity.ok(r);
		}
		return ResponseEntity.notFound().build();
		
	}
	
	@PostMapping(produces ="application/json", consumes ="application/json")
	 public Reponse createReponse (@RequestBody Reponse reponse) {
		 return service.createReponse(reponse);
	 }
	
 	@DeleteMapping(value ="/delete/{id:[0-9]+}", produces = MediaType.TEXT_PLAIN_VALUE)
 	public ResponseEntity<String> deleteReponseById(@PathVariable long id)   {
		
		 try {
			service.deleteReponseById(id);
			return ResponseEntity.ok("Reponse supprimée");
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
 		}
 	 @PutMapping( value ="/update/{id:[0-9]+}",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	  public void updateQuizz(@RequestBody Reponse reponse, @PathVariable long id)
	  {
		  service.updateReponseById(reponse,id);
		  //service.createUser(user);
	  }
 	@GetMapping(value = "listreponse/{id:[0-9]+}", produces ="application/json")
	public ResponseEntity<List<Reponse>> findReponseByQuestionId(@PathVariable long id)   {
		Question question = qservice.findById(id);
		//List<Question> q = service.findquestionByIdQuizz(quizz);
		List<Reponse> r =  (List<Reponse>) question.getReponse();
		if (r!=null)
		{ return ResponseEntity.ok(r);}
		return ResponseEntity.notFound().build();
	
	}

}
