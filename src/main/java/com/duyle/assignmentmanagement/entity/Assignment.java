package com.duyle.assignmentmanagement.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Assignment")
public class Assignment implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column()
	private String subject;
	
	@Column()
	private String content;
	
	@Column()
	private String due_date;
	
	@Column()
	private String attachment;
	
	
	@ManyToMany
	@JoinTable(name="Group_Assignment",joinColumns ={@JoinColumn(name="assignment_id")},inverseJoinColumns={@JoinColumn(name="group_id")})
	private List<Group> groups;
	
	@ManyToOne
	@JoinColumn(name="reporter_id")
	private User user;
	
	@OneToMany(mappedBy="assignment",cascade=CascadeType.ALL)
	private List<Submission> submissions = new ArrayList<>();
	
	
	
	public List<Submission> getSubmissions() {
		return submissions;
	}


	public void setSubmissions(List<Submission> submissions) {
		this.submissions = submissions;
	}


	public Assignment(){
		
	}
	

	public User getUser() {
		return user;
	}




	public void setUser(User user) {
		this.user = user;
	}




	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getDue_date() {
		return due_date;
	}


	public void setDue_date(String due_date) {
		this.due_date = due_date;
	}


	public String getAttachment() {
		return attachment;
	}


	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}


	public List<Group> getGroups() {
		return groups;
	}


	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}


	public Assignment(String subject, String content, String due_date, String attachment, List<Group> groups) {
		super();
		this.subject = subject;
		this.content = content;
		this.due_date = due_date;
		this.attachment = attachment;
		this.groups = groups;
	}
	
	
	
	
	
}
