package com.duyle.assignmentmanagement.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.duyle.assignmentmanagement.entity.Group;
import com.duyle.assignmentmanagement.entity.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Integer id;
	
	@JsonProperty("email")
	private String email;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("password")
	private String password;
	
	@JsonProperty("gender")
	private String gender;
	
	@JsonProperty("role")
	private String role;
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("groups")
	private List<GroupDTO> groups;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("assignments")
	private List<AssignmentDTO> assignmentDTOs;
	
	
	public UserDTO(List<AssignmentDTO> assignmentDTOs) {
		this.assignmentDTOs = assignmentDTOs;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<GroupDTO> getGroups() {
		return groups;
	}

	public void setGroups(List<GroupDTO> groups) {
		this.groups = groups;
	}
	
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserDTO(@JsonProperty("id")Integer id,@JsonProperty("email")String email,@JsonProperty("password") String password,@JsonProperty("name") String name, @JsonProperty("gender")String gender,@JsonProperty("role")
	 String role,@JsonProperty("groups") List<GroupDTO> groups) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.gender = gender;
		this.role = role;
		this.password=password;
		this.groups = groups;
	}
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public static UserDTO fromEntity(User user) {
		List<Group> groups = user.getGroups();
		List<GroupDTO> groupDTOs = new ArrayList<>();
		for (Group group:groups) {
			groupDTOs.add(GroupDTO.fromEntity(group));
		}
		return new UserDTO(user.getUserid(),user.getEmail(), user.getPassword(),user.getName(), user.getGender(),user.getRole(), groupDTOs);
	}
	
	public static UserDTO fromEntityByGroupId(User user) {
		return new UserDTO(user.getUserid(),user.getEmail(), user.getPassword(),user.getName(), user.getGender(), user.getRole(), null);
	}
	
	
	

}
