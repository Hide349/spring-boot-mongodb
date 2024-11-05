package com.ruanp.springmongodb.resources;


import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ruanp.springmongodb.domain.Post;
import com.ruanp.springmongodb.domain.User;
import com.ruanp.springmongodb.dto.UserDTO;
import com.ruanp.springmongodb.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	
	@Autowired
	private UserService service;
	
	// Também pode ser feito com o @GetMapping
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {
		
		List<User> list =service.findAll();
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id){
		User user = service.findById(id);
		
		return ResponseEntity.ok().body(new UserDTO(user));
	}
	
	@PostMapping()
	public ResponseEntity<Void> insert(@RequestBody UserDTO userDto){
		User user = service.fromDTO(userDto);
		user = service.insert(user);
	
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id){
		service.delete(id);
		return ResponseEntity.noContent().build();
		
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Void> update(@RequestBody UserDTO objdto,@PathVariable String id ){
		User obj = service.fromDTO(objdto);
		obj.setId(id);
		service.update(obj);
		return ResponseEntity.noContent().build();
		
	}
	
	
	
	@GetMapping("/{id}/posts")
	
	public ResponseEntity<List<Post>> findPosts(@PathVariable String id){
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj.getPosts());
	}
	
}
