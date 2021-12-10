package com.example.kanban.repository;

import com.example.kanban.model.Projects;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends MongoRepository<Projects, ObjectId>{
	Optional<Projects> findById(ObjectId _id);

	public Projects findByName(String name);
}
