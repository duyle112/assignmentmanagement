package com.duyle.assignmentmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.duyle.assignmentmanagement.entity.User;
import com.duyle.assignmentmanagement.model.GroupDTO;
import com.duyle.assignmentmanagement.model.UserDTO;
import com.duyle.assignmentmanagement.service.AssignmentMagService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	AssignmentMagService service;
	
	@RequestMapping()
	public ResponseEntity<List<UserDTO>> getAll() {
		System.out.println("abccdasdsadaaaaaaaaaaa");
		List<UserDTO> userDTOs = service.findAll();
		if (userDTOs==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.ok(userDTOs);
	}
	
	@RequestMapping(value="/{groupId}",method=RequestMethod.GET)
	public ResponseEntity<GroupDTO> getUserByGroupId(@PathVariable int groupId) {
		GroupDTO groupDTO = service.findById(groupId);
		if (groupDTO == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.ok(groupDTO);
	}
	
	@RequestMapping(value="/info/{userId}",method=RequestMethod.GET)
	public ResponseEntity<UserDTO> getUserInfo(@PathVariable int userId) {
		UserDTO userDTO = service.findByUserId(userId);
		if (userDTO == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.ok(userDTO);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<String> updateUserInfo(@RequestBody UserDTO userDTO) {
		User user = service.updateUserInfo(userDTO);
		if (user == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ERROR");
		}
		return ResponseEntity.ok("SUCCESS");
	}
}
