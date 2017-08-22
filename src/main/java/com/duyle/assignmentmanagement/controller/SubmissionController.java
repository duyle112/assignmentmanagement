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

import com.duyle.assignmentmanagement.model.SubmissionDTO;
import com.duyle.assignmentmanagement.service.AssignmentMagService;

@RestController
@RequestMapping("/submission")
public class SubmissionController {
	
	@Autowired
	private AssignmentMagService service;
	
	@RequestMapping(value="/{assignmentId}/{userId}",method=RequestMethod.POST)
	public ResponseEntity<String> submitAssignment(@RequestBody SubmissionDTO submissionDTO,@PathVariable int assignmentId, @PathVariable int userId) {
		service.submitAssignment(submissionDTO, assignmentId, userId);
		return ResponseEntity.ok("Success");
	}
	
	@RequestMapping(value="{assignmentId}")
	public ResponseEntity<List<SubmissionDTO>> getSubmission(@PathVariable int assignmentId) {
		List<SubmissionDTO> submissionDTOs = service.getSubmissions(assignmentId);
		if (submissionDTOs == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.ok(submissionDTOs);
	}
}
