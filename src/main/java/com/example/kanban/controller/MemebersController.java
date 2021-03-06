package com.example.kanban.controller;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.kanban.model.Issues;
import com.example.kanban.model.Members;
import com.example.kanban.repository.MemberRepository;

@RestController
@RequestMapping("/Member")
public class MemebersController {

	@Autowired
	private MemberRepository memberRepository;
	
	//Create Operation
		@RequestMapping(value= "/new", method= RequestMethod.POST)
		public Members create(@Validated @RequestBody Members Member) {
			Member.setId(ObjectId.get());
			memberRepository.save(Member);
			return Member;
		}
		
		@CrossOrigin(origins="*")
		@RequestMapping(value = "/", method= RequestMethod.GET)
		public List<Members> getAllIssues(){
			return memberRepository.findAll();
		}
		
		@CrossOrigin(origins="*")
		@RequestMapping(value = "/includes", method= RequestMethod.GET)
		public List<Members> getAllMembersStartingWith(@RequestParam (name= "data", required=false) String[] item){
			List<Members> list=  memberRepository.findAll();
			if(item== null ||  item.length<1 ) {
				return list;
			}
			List<Members> finalList = new ArrayList<>() ;

			for(int i=0;i<item.length;i++) {
				
				String nameOfItem= item[i];
				for(int j=0;j<list.size();j++) {
					if(list.get(j).getName().contains(nameOfItem)) {
						finalList.add(list.get(j));
					}
				}
			}
			return finalList;
			
		}
		@RequestMapping(value = "/{id}", method= RequestMethod.GET)
		public  Optional<Members> getIssueById (@PathVariable("id") ObjectId _id) {
			return memberRepository.findById(_id);
		}
		
		@RequestMapping(value= "/{id}", method= RequestMethod.POST)
		public void modifyBookById(@PathVariable("id") ObjectId _id,@Validated @RequestBody Members Member) {
			Member.setId(_id);
			memberRepository.save(Member);
		}

		@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
		public void deleteBook(@PathVariable("id") ObjectId _id) {
			memberRepository.deleteById(_id);
		}
}
