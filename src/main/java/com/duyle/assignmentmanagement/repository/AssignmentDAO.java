package com.duyle.assignmentmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.duyle.assignmentmanagement.entity.Assignment;

public interface AssignmentDAO extends JpaRepository<Assignment, Integer>{
	
}
