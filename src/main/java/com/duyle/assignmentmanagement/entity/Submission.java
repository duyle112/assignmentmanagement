package com.duyle.assignmentmanagement.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="Submission")
public class Submission implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="assignment_id")
	private Assignment assignment;
	
	@Column()
	private String sub_date;
	
	@Column()
	private int score;
	
	@Column()
	private String attachment;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Assignment getAssignment() {
		return assignment;
	}

	public void setAssignment(Assignment assignment) {
		this.assignment = assignment;
	}

	public String getSub_date() {
		return sub_date;
	}

	public void setSub_date(String sub_date) {
		this.sub_date = sub_date;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public Submission() {
		
	}

	public Submission( Assignment assignment, String sub_date, int score, String attachment, User user) {
		super();
		this.assignment = assignment;
		this.sub_date = sub_date;
		this.score = score;
		this.attachment = attachment;
		this.user = user;
	}
	
	
	
}
