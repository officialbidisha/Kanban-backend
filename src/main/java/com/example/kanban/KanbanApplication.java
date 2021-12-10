package com.example.kanban;

import com.example.kanban.repository.ProjectRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication 
(exclude={SecurityAutoConfiguration.class})
public class KanbanApplication implements CommandLineRunner{

	@Autowired
	private ProjectRepository projectRepository;


	public static void main(String[] args) {
		System.out.println("Spring application");
		SpringApplication.run(KanbanApplication.class, args);
	}

	@Override
	public void run(String ...strings) throws Exception{
		System.out.println("Project data");
		System.out.println(projectRepository.findAll());
	}

}
