package com.ruanp.springmongodb.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ruanp.springmongodb.domain.Post;
import com.ruanp.springmongodb.services.PostService;

@RestController
@RequestMapping(value="/posts")
public class PostResource {

	
	@Autowired
	private PostService service;
	
	@GetMapping("/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id){
		Post post = service.findPostById(id);
		return ResponseEntity.ok().body(post);
	}
}
