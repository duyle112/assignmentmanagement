package com.duyle.assignmentmanagement.model;

import java.util.List;

import com.duyle.assignmentmanagement.entity.Assignment;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AssignmentDTO {
	
	@JsonProperty("id")
	private int id;
	
	@JsonProperty("subject")
	private String subject;
	
	@JsonProperty("content")
	private String content;
	
	@JsonProperty("due_date")
	private String due_date;
	
	@JsonProperty("attachment")
	private String attachment;
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("groups")
	private List<GroupDTO> groupDTOs;
	

	public AssignmentDTO(int id, String subject, String content, String due_date, String attachment,
			List<GroupDTO> groupDTOs) {
		super();
		this.id = id;
		this.subject = subject;
		this.content = content;
		this.due_date = due_date;
		this.attachment = attachment;
		this.groupDTOs = groupDTOs;
	}
	
	public AssignmentDTO() {
		
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

	public List<GroupDTO> getGroupDTOs() {
		return groupDTOs;
	}

	public void setGroupDTOs(List<GroupDTO> groupDTOs) {
		this.groupDTOs = groupDTOs;
	}
	
	public static AssignmentDTO fromEntity (Assignment assignment) {
		return new AssignmentDTO(assignment.getId(),assignment.getSubject(), assignment.getContent(), assignment.getDue_date(), assignment.getAttachment(), null);
	}
	
	
	
}
