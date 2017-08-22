package com.duyle.assignmentmanagement.model;

import com.duyle.assignmentmanagement.entity.Submission;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SubmissionDTO {
	@JsonProperty("id")
	private int id;
	
	private String sub_date;
	private int score;
	private String attachment;
	
	@JsonProperty("submiter")
	private UserDTO userDTO;

	public SubmissionDTO () {
		
	}
	
	public SubmissionDTO(int id, String sub_date, int score, String attachment, UserDTO userDTO) {
		super();
		this.id = id;
		this.sub_date = sub_date;
		this.score = score;
		this.attachment = attachment;
		this.userDTO = userDTO;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public UserDTO getUserDTO() {
		return userDTO;
	}

	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}

	public static SubmissionDTO fromEntity(Submission submission) {
		// TODO Auto-generated method stub
		UserDTO userDTO = UserDTO.fromEntity(submission.getUser());
		return new SubmissionDTO(submission.getId(),submission.getSub_date(),submission.getScore(),submission.getAttachment(),userDTO);
	}
	
	
}
