package com.example.kanban.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Projects")
public class Projects {

	@Id
	private ObjectId id;

	private String name;
	private String description;
	private String[] members;

	public Projects(ObjectId id, String name, String description, String[] members) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.members = members;
	}

	public String getId() {
		return this.id.toHexString();
	}

	public String getName() {
		return this.name;
	}

	public String getDescription() {
		return this.description;
	}

	public String[] getMembers() {
		return this.members;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setMembers(String[] members) {
		this.members = members;
	}

	@Override
	public String toString() {
		return "Users{" + "id" + id.toHexString() + " name " + name + "}";
	}

}
