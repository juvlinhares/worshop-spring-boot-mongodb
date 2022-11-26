package com.juvlinhares.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.juvlinhares.workshopmongo.domain.User;
import com.juvlinhares.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	//injetar o UserRepository p fazer a operação com o bd: 
	
	@Autowired
	private UserRepository userRepository;
	@Override
	public void run(String... args) throws Exception {
		//limpar o bd:
		userRepository.deleteAll();
		
		//instanciar o obj e salvar no bd:
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		//salva novos Users no bd
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
	}

}
