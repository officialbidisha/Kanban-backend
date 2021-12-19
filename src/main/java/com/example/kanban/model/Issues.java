package com.example.kanban.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Issues")
public class Issues {

	public Issues(ObjectId id, String projectname, String type, String assignee, String title, String summary,
			String status, int storypoint, String priority, String description) {
		super();
		this.id = id;
		this.projectname = projectname;
		this.type = type;
		this.assignee = assignee;
		this.title = title;
		this.summary = summary;
		this.status = status;
		this.storypoint = storypoint;
		this.priority = priority;
		this.description = description;
	}

	@Id
	private ObjectId id;
	private String projectname;
	private String type;
	private String assignee;
	public String title;
	private String summary;
	private String status;
	private int storypoint;
	private String priority;
	private String description;

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getId() {
		return id.toHexString();
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getProjectname() {
		return projectname;
	}

	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAssignee() {
		return assignee;
	}

	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getStorypoint() {
		return storypoint;
	}

	public void setStorypoint(int storypoint) {
		this.storypoint = storypoint;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
