package com.soni.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.soni.model.Post;
import com.soni.service.ForumService;

@Controller
@RequestMapping("/forum")
public class ForumController {
	
	@Autowired
	private ForumService forumService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/post")
	public ModelAndView createPost(@RequestParam String postContent){
		Post post = new Post();
		post.setContent(postContent);
		forumService.createPost(post);
		return showForm();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/")
	public ModelAndView showForm(){
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("posts", forumService.getAllPosts());
		return new ModelAndView("posts",model);
	}
}
