package com.ruanp.springmongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ruanp.springmongodb.domain.Post;

public interface PostRepository extends MongoRepository<Post,String>  {

	List<Post> findByTitleContainingIgnoreCase(String text);
}
