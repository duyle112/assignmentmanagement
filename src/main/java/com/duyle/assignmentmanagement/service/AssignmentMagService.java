package com.duyle.assignmentmanagement.service;

import java.util.List;

import com.duyle.assignmentmanagement.entity.User;
import com.duyle.assignmentmanagement.model.AssignmentDTO;
import com.duyle.assignmentmanagement.model.GroupDTO;
import com.duyle.assignmentmanagement.model.SubmissionDTO;
import com.duyle.assignmentmanagement.model.UserDTO;



public interface AssignmentMagService {
	List<UserDTO> findAll();
	GroupDTO findById(int id);
	UserDTO findByUserId(int id);
	User updateUserInfo(UserDTO userDto);
	void save(AssignmentDTO assignmentDTO);
	GroupDTO getAssignment(int id);
	List<AssignmentDTO> getAssignmentsfromTeacher(int id);
	void submitAssignment(SubmissionDTO submissionDTO, int assignmentId, int user_id);
	List<SubmissionDTO> getSubmissions(int assignmentId);
}
