package com.ruanp.springmongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruanp.springmongodb.domain.User;
import com.ruanp.springmongodb.dto.UserDTO;
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
	
	public User insert(User user) {
		
		return rep.insert(user);
	}
	
	
	public void delete(String id) {
		findById(id);
		rep.deleteById(id);
	}
	
	public User update(User user) {
		User newObj = findById(user.getId());
		updateData(newObj,user);
		return rep.save(newObj);
	}
	
	private void updateData(User newObj, User user) {
		newObj.setId(user.getId() != null ? user.getId() : newObj.getId());
		newObj.setName(user.getName() != null ? user.getName() : newObj.getName());
		newObj.setEmail(user.getEmail() != null ? user.getEmail() : newObj.getEmail());
	}

	public User fromDTO(UserDTO dto) {
		return new User(dto.getId(),dto.getName(),dto.getEmail());
	}

}
