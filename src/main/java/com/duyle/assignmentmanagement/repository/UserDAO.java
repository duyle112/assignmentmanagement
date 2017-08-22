package com.duyle.assignmentmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.duyle.assignmentmanagement.entity.User;

public interface UserDAO extends JpaRepository<User, Integer>{
	User findById (@Param("id") int id);

}
