package com.ruanp.springmongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ruanp.springmongodb.domain.Post;

public interface PostRepository extends MongoRepository<Post,String>  {

}
