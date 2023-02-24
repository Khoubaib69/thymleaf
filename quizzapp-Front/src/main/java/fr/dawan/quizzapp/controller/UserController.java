package fr.dawan.quizzapp.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import fr.dawan.quizzapp.entities.Users;
import fr.dawan.quizzapp.formBeans.UserForm;
@Controller
public class UserController {
	final String BASE_URL = "http://localhost:8081";
	
	@Autowired
	ObjectMapper objectMapper;
	
	@Autowired
	private RestTemplate restTemplate; //Classe qui permet d'interagir avec des API REST
	
	
	private void getAllUsers(Model model) {
		Users[] userTab = restTemplate.getForObject(BASE_URL+"/api/users", Users[].class);
		List<Users> users = Arrays.asList(userTab);
		model.addAttribute("users",users);
	}
	
	
	
	@GetMapping("/users")
	public String AllUser(Model model) {
		getAllUsers(model);
		return "users";
	}
	@GetMapping("/")
	public String Accueil() {
		return "index";
	}
	@PostMapping("users/addOrUpdate")
	public String addUpdate(@Valid @ModelAttribute("userForm") UserForm userForm, BindingResult bindingResult, Model model,
			 HttpSession session) throws IOException {
		
	
		
		
		if(bindingResult.hasErrors()) {
			getAllUsers(model);
			return "users";
		}
		
		Users user = new Users();
		
		BeanUtils.copyProperties(userForm, user);
		
		
		//Créer userJson: un user sous format json : {"firstName":"ddd", "lastName":"ddd".....}
//		String userJson = objectMapper.writeValueAsString(userForm);
//		LinkedMultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
//		
//		params.add("user", userJson);
//
//		HttpHeaders headers = new HttpHeaders();
//		headers.setContentType(MediaType.APPLICATION_JSON);
//		HttpEntity<LinkedMultiValueMap<String, Object>> httpEntity = 
//				new HttpEntity<LinkedMultiValueMap<String,Object>>(params, headers);
		ResponseEntity<Users> postForEntity= restTemplate.postForEntity(BASE_URL+"/api/users/save",user, Users.class);
		
		return "redirect:/users";
		
	
}
	@ModelAttribute("userForm")
	public UserForm getUserForm () {
		return new UserForm();
	}
}
