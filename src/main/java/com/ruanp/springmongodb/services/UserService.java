package com.ruanp.springmongodb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruanp.springmongodb.domain.User;
import com.ruanp.springmongodb.repository.UserRepository;

@Service
public class UserService {

	
	@Autowired
	private UserRepository rep; 
	
	public List<User> findAll(){
		return rep.findAll();
	}
}
