package com.ruanp.springmongodb.resources;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ruanp.springmongodb.domain.User;
import com.ruanp.springmongodb.dto.UserDTO;
import com.ruanp.springmongodb.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	
	@Autowired
	private UserService service;
	
	// Também pode ser feito com o @GetMapping
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> findAll() {
		
		List<User> list =service.findAll();
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
}
