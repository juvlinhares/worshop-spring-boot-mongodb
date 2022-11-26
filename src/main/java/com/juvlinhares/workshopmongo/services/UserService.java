package com.juvlinhares.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juvlinhares.workshopmongo.domain.User;
import com.juvlinhares.workshopmongo.repository.UserRepository;

@Service //serviço injetavel em outras classes
public class UserService {
	
	@Autowired //o proprio spring proca e define o obj
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll(); //vai no bd e retornar todos os objetos user
	}
 
	
}
