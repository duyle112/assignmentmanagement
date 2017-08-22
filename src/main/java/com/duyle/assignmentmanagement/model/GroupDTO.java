package com.duyle.assignmentmanagement.model;

import java.util.ArrayList;
import java.util.List;

import com.duyle.assignmentmanagement.entity.Assignment;
import com.duyle.assignmentmanagement.entity.Group;
import com.duyle.assignmentmanagement.entity.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GroupDTO {

	
	@JsonProperty("group_id")
	private int id;
	
	@JsonProperty("group_name")
	private String name;
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("users")
	private List<UserDTO> userDTOs;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("assignments")
	private List<AssignmentDTO> assignmentDTOs;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

	public List<UserDTO> getUserDTOs() {
		return userDTOs;
	}

	public void setUserDTOs(List<UserDTO> userDTOs) {
		this.userDTOs = userDTOs;
	}

	public GroupDTO(@JsonProperty("group_id")int id, @JsonProperty("group_name")String name, @JsonProperty("users")List<UserDTO>userDTOs,@JsonProperty("assignments") List<AssignmentDTO> assignmentDTOs) {
		super();
		this.id = id;
		this.name = name;
		this.userDTOs = userDTOs;
		this.assignmentDTOs = assignmentDTOs;
	}
	
	public static GroupDTO fromEntity(Group group) {
		return new GroupDTO(group.getGroupid(), group.getGroup_name(), null, null);
	}
	
	public static GroupDTO fromEntityListUser(Group group) {
		List<User> users = group.getUsers();
		List<UserDTO> userDTOs = new ArrayList<>();
		for (User user:users) {
			userDTOs.add(UserDTO.fromEntityByGroupId(user));
		}
		return new GroupDTO(group.getGroupid(), group.getGroup_name(), userDTOs, null);
	}
	
	public static GroupDTO fromEntityGetAssignments(Group group) {
		List<Assignment> assignments = group.getAssignments();
		List<AssignmentDTO> assignmentDTOs = new ArrayList<>();
		for (Assignment assignment : assignments) {
			assignmentDTOs.add(AssignmentDTO.fromEntity(assignment));
		}
		return new GroupDTO(group.getGroupid(), group.getGroup_name(), null, assignmentDTOs);
	}
}
