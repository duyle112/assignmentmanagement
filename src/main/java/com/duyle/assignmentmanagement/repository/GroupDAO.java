package com.duyle.assignmentmanagement.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.duyle.assignmentmanagement.entity.Group;

public interface GroupDAO extends JpaRepository<Group, Integer>{
	Group findById (@Param("id") int group_id);
}
