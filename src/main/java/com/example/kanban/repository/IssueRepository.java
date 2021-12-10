package com.example.kanban.repository;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.kanban.model.Issues;

@Repository
public interface IssueRepository extends MongoRepository<Issues, ObjectId> {
	Optional<Issues> findById(ObjectId _id);

	public List<Issues> findByType(String type);

	public Optional<Issues> findByTitle(String title);
}
