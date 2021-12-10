package com.example.kanban.repository;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.kanban.model.Members;

@Repository
public interface MemberRepository extends MongoRepository<Members, ObjectId> {
	Optional<Members> findById(ObjectId _id);
	
	public Members findByName(String name);
}
