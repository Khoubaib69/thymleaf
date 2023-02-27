package fr.dawan.quizzapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
import fr.dawan.quizzapp.service.IQuestionService;
import fr.dawan.quizzapp.service.IQuizzService;

@RestController
@RequestMapping("/api/question")
public class QuestionController {
	
	@Autowired
	private IQuestionService service;
	@Autowired
	private IQuizzService qservice;
	
	@GetMapping(produces="application/json")
	public List<Question> findAll(){
	return service.findAll();
	}
	
	@GetMapping(value = "/{id:[0-9]+}", produces ="application/json")
	public ResponseEntity<Question> findQuestionById(@PathVariable long id)   {
		Question q = service.findById(id);
		if (q!=null)
		{ return ResponseEntity.ok(q);}
		return ResponseEntity.notFound().build();
	
	}
	@GetMapping(value = "listquestions/{id:[0-9]+}", produces ="application/json")
	public ResponseEntity<List<Question>> findQuestionByQuizzId(@PathVariable long id)   {
		Quizz quizz = qservice.findQuizzById(id);
		//List<Question> q = service.findquestionByIdQuizz(quizz);
		List<Question> q =  (List<Question>) quizz.getQuestion();
		if (q!=null)
		{ return ResponseEntity.ok(q);}
		return ResponseEntity.notFound().build();
	
	}
	
	@PostMapping(produces ="application/json", consumes ="application/json")
	 public Question createQuestion (@RequestBody Question question) {
		 return service.createQuestion(question);
	 }
	
	@DeleteMapping(value ="/delete/{id:[0-9]+}", produces = MediaType.TEXT_PLAIN_VALUE)
 	public ResponseEntity<String> deleteQuestionById(@PathVariable long id)   {
		
		 try {
			service.deleteQuestionById(id);
			return ResponseEntity.ok("Question supprimée");
		} catch (Exception e) {
			
			return ResponseEntity.notFound().build();
			
		}
 		}
	
	@PutMapping(value ="/update/{id:[0-9]+}",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	  public void updateQuestion(@RequestBody Question question, @PathVariable long id)
	  {
		  service.updateQuestionById(question,id);
	  }

}
