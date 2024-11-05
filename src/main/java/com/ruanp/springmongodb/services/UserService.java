package com.ruanp.springmongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruanp.springmongodb.domain.User;
import com.ruanp.springmongodb.repository.UserRepository;
import com.ruanp.springmongodb.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {

	
	@Autowired
	private UserRepository rep; 
	
	public List<User> findAll(){
		return rep.findAll();
	}
	
	public User findById(String id) {
		Optional<User> user = rep.findById(id);

		return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
 	}
}
