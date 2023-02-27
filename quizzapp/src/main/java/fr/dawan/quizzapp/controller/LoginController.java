package fr.dawan.quizzapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.dawan.quizzapp.dtos.LoginDto;
import fr.dawan.quizzapp.dtos.LoginResponseDto;
import fr.dawan.quizzapp.service.UserService;

@RestController
	public class LoginController {
		
		@Autowired
		private UserService userService;
		
		@PostMapping(value="/login", consumes="application/json", produces="application/json")
		public LoginResponseDto CheckLogin(@RequestBody LoginDto loginDto) throws Exception {
			return userService.CheckLogin(loginDto);
		}

	}
