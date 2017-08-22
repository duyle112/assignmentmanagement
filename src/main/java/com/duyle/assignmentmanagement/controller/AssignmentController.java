package com.duyle.assignmentmanagement.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.duyle.assignmentmanagement.model.AssignmentDTO;
import com.duyle.assignmentmanagement.model.GroupDTO;
import com.duyle.assignmentmanagement.model.UserDTO;
import com.duyle.assignmentmanagement.service.AssignmentMagService;

@RestController
@RequestMapping("/assignments")
public class AssignmentController {
	
	@Autowired
	AssignmentMagService assignmentMagService;
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<String> saveAssignment(@RequestBody AssignmentDTO assignmentDTO) {
		assignmentMagService.save(assignmentDTO);
		return ResponseEntity.ok("Success");
	}
	
	@RequestMapping(value="/{userid}",method=RequestMethod.POST)
	public ResponseEntity<List<GroupDTO>> getAssignment(@PathVariable int userid) {
		int [] groups = getGroupsId(userid);
		List<GroupDTO> groupDTOs = new ArrayList<>();
		for (int i = 0; i < groups.length; i++) {
			GroupDTO groupDTO = assignmentMagService.getAssignment(groups[i]);
			groupDTOs.add(groupDTO);
		}
		return ResponseEntity.ok(groupDTOs);
	}
	
	@RequestMapping(value="/teacher/{userid}",method=RequestMethod.POST)
	public ResponseEntity<List<AssignmentDTO>> getAssignmentFromTeacher(@PathVariable int userid) {
		List<AssignmentDTO> assignmentDTOs = assignmentMagService.getAssignmentsfromTeacher(userid);
		if (assignmentDTOs == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.ok(assignmentDTOs);
	}
	
	public int[] getGroupsId(int id) {
		UserDTO userDTO = assignmentMagService.findByUserId(id);
		
		List<GroupDTO> groupDTOs = userDTO.getGroups();
		if (groupDTOs == null) {
			return null;
		}
		int [] groups = new int[groupDTOs.size()];
		int i = 0;
		for (GroupDTO groupDTO:groupDTOs) {
			groups[i++] = groupDTO.getId();
		}
		return groups;
	}
	
	
}
