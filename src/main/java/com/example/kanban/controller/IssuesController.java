package com.example.kanban.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

	@CrossOrigin(origins="*")
	@RequestMapping(value = "/", method= RequestMethod.GET)
	public List<Issues> getAllIssues(){
		return issueRepository.findAll();
	}
	
	@CrossOrigin(origins="*")
	@RequestMapping(value = "/startsWith", method= RequestMethod.GET)
	public List<Issues> getAllIssuesStartingWith(@RequestParam("data") String itemid){
		List<Issues> list=  issueRepository.findAll();
		if(itemid == "") {
			System.out.println(list);
			return list;
		}
		List<Issues> finalList = new ArrayList<>() ;
		for(int i=0;i<list.size();i++) {
			if(list.get(i).title.toLowerCase().contains(itemid.toLowerCase()) ) {
				finalList.add(list.get(i));
			}
		}
		
		return finalList;
		
	}
	
	@CrossOrigin(origins="*")
	@RequestMapping(value = "/{id}", method= RequestMethod.GET)
	public  Optional<Issues> getIssueById (@PathVariable("id") ObjectId _id) {
		return issueRepository.findById(_id);
	}
	
	@CrossOrigin(origins="*")
	@RequestMapping(value= "/{id}", method= RequestMethod.POST)
	public HttpStatus modifyBookById(@PathVariable("id") ObjectId _id,@Validated @RequestBody Issues Issue) {
		try {
		Issue.setId(_id);
		issueRepository.save(Issue);
		return HttpStatus.CREATED;
		}
		catch(Exception e) {
			return HttpStatus.EXPECTATION_FAILED;
		}
	}

	@CrossOrigin(origins="*")
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public HttpStatus deleteIssue(@PathVariable("id") ObjectId _id) {
		try {
			
			issueRepository.deleteById(_id);
			return HttpStatus.ACCEPTED;
		}
		catch(Exception e) {
			return HttpStatus.BAD_REQUEST;
		}

	}
}
