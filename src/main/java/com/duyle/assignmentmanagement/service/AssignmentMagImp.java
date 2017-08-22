package com.duyle.assignmentmanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duyle.assignmentmanagement.entity.Assignment;
import com.duyle.assignmentmanagement.entity.Group;
import com.duyle.assignmentmanagement.entity.Submission;
import com.duyle.assignmentmanagement.entity.User;
import com.duyle.assignmentmanagement.model.AssignmentDTO;
import com.duyle.assignmentmanagement.model.GroupDTO;
import com.duyle.assignmentmanagement.model.SubmissionDTO;
import com.duyle.assignmentmanagement.model.UserDTO;
import com.duyle.assignmentmanagement.repository.AssignmentDAO;
import com.duyle.assignmentmanagement.repository.GroupDAO;
import com.duyle.assignmentmanagement.repository.UserDAO;

@Service()
public class AssignmentMagImp implements AssignmentMagService{
	
	@Autowired
	private UserDAO userDao;
	
	@Autowired
	private GroupDAO groupDao;
	
	@Autowired
	private AssignmentDAO assignmentDao;

	@Override
	public List<UserDTO> findAll() {
		// TODO Auto-generated method stub
		System.out.println("abc");
		List<User> users = userDao.findAll();
		List<UserDTO> userDTOs = new ArrayList<>();
		if (users==null) {
			return null;
		}
		for (User user:users) {
			userDTOs.add(UserDTO.fromEntity(user));
		}
		return userDTOs;
	}

	@Override
	public GroupDTO findById(int id) {
		// TODO Auto-generated method stub
		Group group = groupDao.findById(id);
		if (group == null) {
			return null;
		}
		return GroupDTO.fromEntityListUser(group);
	}

	@Override
	public User updateUserInfo(UserDTO userDto) {
		// TODO Auto-generated method stub
		User user =userDao.findOne(userDto.getId());
		user.setEmail(userDto.getEmail());
		user.setGender(userDto.getGender());
		user.setName(userDto.getName());
		user.setPassword(userDto.getPassword());
		return userDao.saveAndFlush(user);
	}

	@Override
	public UserDTO findByUserId(int id) {
		// TODO Auto-generated method stub
		User user = userDao.findById(id);
		if (user == null) {
			return null;
		}
		return UserDTO.fromEntity(user);
	}

	@Override
	public void save(AssignmentDTO assignmentDTO) {
		// TODO Auto-generated method stub
		
		List<GroupDTO> groupDTOs = assignmentDTO.getGroupDTOs();
		List<Group> groups = new ArrayList<>();
		for (GroupDTO group:groupDTOs) {
			groups.add(new Group(group.getId(),group.getName(),null));
		}
		Assignment assignment = new Assignment(assignmentDTO.getSubject(),assignmentDTO.getContent(), assignmentDTO.getDue_date(), assignmentDTO.getAttachment(),groups);
		assignmentDao.save(assignment);
		
	}

	@Override
	public GroupDTO getAssignment(int id) {
		// TODO Auto-generated method stub
		Group group = groupDao.findById(id);
		if (group == null) {
			return null;
		}
		return GroupDTO.fromEntityGetAssignments(group);
	}


	@Override
	public List<AssignmentDTO> getAssignmentsfromTeacher(int id) {
		// TODO Auto-generated method stub
		User user = userDao.findById(id);
		if (user.getRole().equals("Student")) {
			return null;
		}
		List<Assignment> assignments = user.getAssignments();
		if (assignments == null) {
			return null;
		}
		List<AssignmentDTO> assignmentDTOs = new ArrayList<>();
		for (Assignment assignment:assignments) {
			assignmentDTOs.add(AssignmentDTO.fromEntity(assignment));
		}
		return assignmentDTOs;
		
	}

	@Override
	public void submitAssignment(SubmissionDTO submissionDTO, int assignmentId, int user_id) {
		// TODO Auto-generated method stub
		Assignment assignment = assignmentDao.findOne(assignmentId);
		if (assignment == null) {
			return;
		}
		User user = userDao.findById(user_id);
		Submission submission = new Submission(assignment, submissionDTO.getSub_date(), submissionDTO.getScore(), submissionDTO.getAttachment(), user);
		List<Submission> submissions = assignment.getSubmissions();
		submissions.add(submission);
		assignment.setSubmissions(submissions);
		assignmentDao.save(assignment);
	}

	@Override
	public List<SubmissionDTO> getSubmissions(int assignmentId) {
		// TODO Auto-generated method stub
		Assignment assignment = assignmentDao.findOne(assignmentId);
		if (assignment == null) {
			return null;
		}
		List<Submission> submissions = assignment.getSubmissions();
		List<SubmissionDTO> submissionDTOs = new ArrayList<>();
		for (Submission submission:submissions) {
			submissionDTOs.add(SubmissionDTO.fromEntity(submission));
		}
		return submissionDTOs;
	}
	
}
