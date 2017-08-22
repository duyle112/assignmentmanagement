package com.duyle.assignmentmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.duyle.assignmentmanagement.model.UserDTO;
import com.duyle.assignmentmanagement.service.AssignmentMagService;

@RestController
@RequestMapping("/login")
public class Login {
	
	@Autowired
	AssignmentMagService service;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> login(@RequestParam String email, @RequestParam String password) {
		List<UserDTO> users = service.findAll();
		
		System.out.println(email+password);
		if (users == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		for (UserDTO userDto:users) {
			if (userDto.getEmail().equals(email)&&userDto.getPassword().equals(password)) {
				return ResponseEntity.status(HttpStatus.OK).body("LOGIN_SUCCESS");
			}
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("FAIL");
	}
}
