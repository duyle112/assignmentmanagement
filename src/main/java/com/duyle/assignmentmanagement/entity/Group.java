package com.duyle.assignmentmanagement.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Groups")
public class Group implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column()
	private String group_name;
	
	
	@ManyToMany(mappedBy="groups")
	private List<User> users;
	
	@ManyToMany(mappedBy="groups")
	private List<Assignment> assignments;

	public int getGroupid() {
		return id;
	}

	public void setGroup_id(int group_id) {
		this.id = group_id;
	}

	public String getGroup_name() {
		return group_name;
	}

	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	public Group() {
		
	}

	public Group(int grouid, String group_name, List<User> users) {
		super();
		this.id = grouid;
		this.group_name = group_name;
		this.users = users;
	}

	public List<Assignment> getAssignments() {
		return assignments;
	}

	public void setAssignments(List<Assignment> assignments) {
		this.assignments = assignments;
	}
}
