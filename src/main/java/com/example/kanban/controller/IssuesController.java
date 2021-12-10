package com.example.kanban.controller;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.kanban.model.Issues;
import com.example.kanban.repository.IssueRepository;

@RestController
@RequestMapping("/Issue")
public class IssuesController {
	
	@Autowired
	private IssueRepository issueRepository;
	
	
	//Create Operation
	@RequestMapping(value= "/new", method= RequestMethod.POST)
	public Issues create(@Validated @RequestBody Issues Issue) {
		Issue.setId(ObjectId.get());
		issueRepository.save(Issue);
		return Issue;
	}
	
	@RequestMapping(value = "/", method= RequestMethod.GET)
	public List<Issues> getAllIssues(){
		return issueRepository.findAll();
	}
	
	@RequestMapping(value = "/{id}", method= RequestMethod.GET)
	public  Optional<Issues> getIssueById (@PathVariable("id") ObjectId _id) {
		return issueRepository.findById(_id);
	}
	
	@RequestMapping(value= "/{id}", method= RequestMethod.POST)
	public void modifyBookById(@PathVariable("id") ObjectId _id,@Validated @RequestBody Issues Issue) {
		Issue.setId(_id);
		issueRepository.save(Issue);
	}

	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteBook(@PathVariable("id") ObjectId _id) {
		issueRepository.deleteById(_id);
	}
}
