package com.duyle.assignmentmanagement.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="Users")
public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column()
	private String email;
	
	@Column()
	private String password;
	
	@Column()
	private String name;
	
	@Column()
	private String gender;
	
	@Column()
	private String role;
	
	@ManyToMany
	@JoinTable(name="belongings", joinColumns={@JoinColumn(name="user_id")},inverseJoinColumns={@JoinColumn(name="groupid")})
	private List<Group> groups;
	
	@OneToMany(mappedBy="user")
	private List<Assignment> assignments;
	
	@OneToMany(mappedBy="user")
	private List<Submission> submissions;
	
	
	
	public List<Submission> getSubmissions() {
		return submissions;
	}

	public void setSubmissions(List<Submission> submissions) {
		this.submissions = submissions;
	}

	public int getUserid() {
		return id;
	}

	public void setUser_id(int user_id) {
		this.id = user_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Group> getGroups() {
		return groups;
	}

	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}
	
	

	public List<Assignment> getAssignments() {
		return assignments;
	}

	public void setAssignments(List<Assignment> assignments) {
		this.assignments = assignments;
	}

	public User(int userid, String email, String password, String name, String gender, String role,
			List<Group> groups) {
		super();
		this.id = userid;
		this.email = email;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.role = role;
		this.groups = groups;
	}
	
	public User(){
		
	}

	public User(int id, String name) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.name = name;
	}
	
	
}
