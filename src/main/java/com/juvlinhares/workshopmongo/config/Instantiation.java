package com.juvlinhares.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.juvlinhares.workshopmongo.domain.Post;
import com.juvlinhares.workshopmongo.domain.User;
import com.juvlinhares.workshopmongo.repository.PostRepository;
import com.juvlinhares.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
		//injetar o UserRepository p fazer a operação com o bd: 
	
	@Autowired
	private UserRepository userRepository;//injeção do user repository
	
	@Autowired
	private PostRepository postRepository;//injeção do user repository
	
	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		//limpar o bd:
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		//instanciar o obj e salvar no bd:
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", maria);
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", maria);
		
		//salva novos Users no bd
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		//salvar os posts no bd
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		
	}

}
