package com.soni.service;

import java.util.List;

import com.soni.model.Post;

public interface ForumService {
	void createPost(Post post);
	public List<Post> getAllPosts();
}
