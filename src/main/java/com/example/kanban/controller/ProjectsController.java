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

import com.example.kanban.model.Projects;
import com.example.kanban.repository.ProjectRepository;


@RestController
@RequestMapping("/Project")
public class ProjectsController {
	
	@Autowired
	private ProjectRepository projectRepository;
	
	
	//Create Operation
	@RequestMapping(value= "/new", method= RequestMethod.POST)
	public Projects create(@Validated @RequestBody Projects project) {
		project.setId(ObjectId.get());
		projectRepository.save(project);
		return project;
	}
	
	@RequestMapping(value = "/", method= RequestMethod.GET)
	public List<Projects> getAllProjects(){
		return projectRepository.findAll();
	}
	
	@RequestMapping(value = "/{id}", method= RequestMethod.GET)
	public  Optional<Projects> getProjectById (@PathVariable("id") ObjectId _id) {
		return projectRepository.findById(_id);
	}
	
	@RequestMapping(value= "/{id}", method= RequestMethod.POST)
	public void modifyBookById(@PathVariable("id") ObjectId _id,@Validated @RequestBody Projects project) {
		project.setId(_id);
		projectRepository.save(project);
	}

	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteBook(@PathVariable("id") ObjectId _id) {
		projectRepository.deleteById(_id);
	}
	
	
}
