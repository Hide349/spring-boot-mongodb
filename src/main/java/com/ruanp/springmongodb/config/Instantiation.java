package com.ruanp.springmongodb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.ruanp.springmongodb.domain.Post;
import com.ruanp.springmongodb.domain.User;
import com.ruanp.springmongodb.dto.AuthorDTO;
import com.ruanp.springmongodb.repository.PostRepository;
import com.ruanp.springmongodb.repository.UserRepository;



@Configuration
public class Instantiation implements CommandLineRunner{

	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		userRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
			
		userRepository.saveAll(Arrays.asList(maria,alex,bob));

		
		Post post1 = new Post(null,sdf.parse("21/03/2018"),"Partiu viagem!!","Vou viajar para são paulo!",new AuthorDTO(maria));
		Post post2 = new Post(null,sdf.parse("21/03/2018"),"Partiu viagem!!","Vou viajar para são paulo!",new AuthorDTO(maria));

		postRepository.saveAll(Arrays.asList(post1,post2));
		
		maria.getPosts().addAll(Arrays.asList(post1,post2));
		userRepository.save(maria);

	}

}
