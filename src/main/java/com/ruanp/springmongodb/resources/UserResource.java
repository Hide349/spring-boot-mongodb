package com.ruanp.springmongodb.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ruanp.springmongodb.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	
	// Também pode ser feito com o @GetMapping
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> findAll() {
		User user1 = new User("1","Ruan","ruan@gmail.com");
		User user2 = new User("1","Ruan","ruan@gmail.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(user1,user2));
		return ResponseEntity.ok().body(list);
	}
}
