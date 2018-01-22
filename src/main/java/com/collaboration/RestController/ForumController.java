package com.collaboration.RestController;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.collaboration.DAO.ForumDAO;
import com.collaboration.model.Forum;



@RestController
public class ForumController {
	@Autowired 
	ForumDAO forumDAO;
	
	@PostMapping(value="/insertForum")
	public ResponseEntity<String> insertForum(@RequestBody Forum forum)
	{
		forum.setCreateDate(new java.util.Date());
	    forum.setStatus("N");
		if(forumDAO.addForum(forum))
		{
			return new ResponseEntity<String>("Forum Added",HttpStatus.OK);
		
		}
		else
		{
			return new ResponseEntity<String>("Error in Response Entity",HttpStatus.SERVICE_UNAVAILABLE);
		}
		}
	
	@PostMapping(value="/updateForum")
	public ResponseEntity<String> updateForum(@RequestBody Forum forum)
	{
		Forum tempForum=forumDAO.getForum(forum.getForumId());
		
		tempForum.setForumName(forum.getForumName());
		tempForum.setForumContent(forum.getForumContent());
		
		if(forumDAO.updateForum(tempForum))	
		{
			return new ResponseEntity<String>("forum updated",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("problem in updating forum",HttpStatus.METHOD_FAILURE);
		}
		
	}
	
	
	@GetMapping(value="/getAllForums")
	public ResponseEntity<ArrayList<Forum>> getAllForums()
	{
		ArrayList listForums=(ArrayList)forumDAO.getAllForums();
		return new ResponseEntity<ArrayList<Forum>>(listForums,HttpStatus.OK);
	}
	
	 @GetMapping("/deleteForum/{forumId}")
	 public ResponseEntity<String> deleteForum(@PathVariable("forumId") int forumId) {
		Forum tempforum = forumDAO.getForum(forumId);
		System.out.println("deletion in forum");
		if (forumDAO.deleteForum(tempforum)) 
		{			
			return new ResponseEntity<String>("forum deleted", HttpStatus.OK);
		} 
		else
		{
			return new ResponseEntity<String>("problem deleting forum", HttpStatus.METHOD_FAILURE);
		}
	}
	 
	 
	 @GetMapping("/approveForum/{forumId}")
		public ResponseEntity<String> approveForum(@PathVariable("forumId") int forumId) {
		 Forum tempforum = forumDAO.getForum(forumId);

			if (forumDAO.approveForum("A", tempforum)) {
				return new ResponseEntity<String>("Forum updated", HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("error in forum updation", HttpStatus.METHOD_FAILURE);
			}
		}

		@GetMapping("/rejectForum/{forumId}")
		public ResponseEntity<String> rejectForum(@PathVariable("forumId") int forumId) {
			 Forum tempforum = forumDAO.getForum(forumId);
			if (forumDAO.rejectForum(tempforum)) {
				return new ResponseEntity<String>("Forum rejected", HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("error in forum rejection", HttpStatus.METHOD_FAILURE);
			}
			
		}
}