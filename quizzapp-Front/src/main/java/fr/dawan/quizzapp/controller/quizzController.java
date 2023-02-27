package fr.dawan.quizzapp.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import fr.dawan.quizzapp.entities.Users;
import fr.dawan.quizzapp.entities.question;
import fr.dawan.quizzapp.entities.quizz;
import fr.dawan.quizzapp.entities.reponse;
@Controller
public class quizzController {
final String BASE_URL = "http://localhost:8081";
	
	@Autowired
	ObjectMapper objectMapper;
	
	@Autowired
	private RestTemplate restTemplate; //Classe qui permet d'interagir avec des API REST
	
	
	private void getAllquizz(Model model) {
		quizz[] quizTab = restTemplate.getForObject(BASE_URL+"/api/quizz", quizz[].class);
		List<quizz> quizz = Arrays.asList(quizTab);
		model.addAttribute("quizz",quizz);
	}
	
	
	
	@GetMapping("/quizzs")
	public String Allquizz(Model model) {
		getAllquizz(model);
		return "quizzs";
}
	@GetMapping("/quizz/questions/{id}")
	public String afficherQuestions(@PathVariable("id") int id,Model model) {
		
		question[] questionTab = restTemplate.getForObject(BASE_URL+"/api/question/listquestions/"+id,question[].class);
	List<question> question =Arrays.asList(questionTab);
	model.addAttribute("question",question);
	return "questions";
}
	@GetMapping("/quizz/questions/reponse/{id}")
	public String afficherReponses(@PathVariable("id") int id,Model model) {	
		reponse[] reponseTab = restTemplate.getForObject(BASE_URL+"/api/reponse/listreponse/"+id,reponse[].class);
	List<reponse> reponse =Arrays.asList(reponseTab);
	model.addAttribute("reponse",reponse);
	return "reponse";
}
		
	
	
	
}
