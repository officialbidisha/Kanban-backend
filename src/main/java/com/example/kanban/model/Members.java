package com.example.kanban.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Members")
public class Members {

	@Id
	private ObjectId id;
	private String name;
	private String[] projects;

	public Members(ObjectId id, String name, String[] projects) {
		super();
		this.id = id;
		this.name = name;
		this.projects = projects;
	}

	public String getId() {
		return id.toHexString();
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getProjects() {
		return projects;
	}

	public void setProjects(String[] projects) {
		this.projects = projects;
	}
	
	

}
