package com.ruanp.springmongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruanp.springmongodb.domain.Post;
import com.ruanp.springmongodb.repository.PostRepository;
import com.ruanp.springmongodb.services.exceptions.ObjectNotFoundException;


@Service
public class PostService {

	
	@Autowired
	private PostRepository rep;
	
	
	public Post findPostById(String id) {
		Optional<Post> post = rep.findById(id);
		
		return post.orElseThrow(() -> new ObjectNotFoundException("Post não encontrado!"));
	}
	
	public List<Post> findByTitle(String text){
		return rep.searchTitle(text);
	}
	
}
