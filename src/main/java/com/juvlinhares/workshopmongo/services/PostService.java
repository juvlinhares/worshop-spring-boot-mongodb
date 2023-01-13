package com.juvlinhares.workshopmongo.services;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juvlinhares.workshopmongo.domain.Post;
import com.juvlinhares.workshopmongo.domain.User;
import com.juvlinhares.workshopmongo.dto.UserDTO;
import com.juvlinhares.workshopmongo.repository.PostRepository;
import com.juvlinhares.workshopmongo.repository.UserRepository;
import com.juvlinhares.workshopmongo.services.exception.ObjectNotFoundException;

@Service // serviço injetavel em outras classes
public class PostService {

	
	@Autowired // o proprio spring proca e define o obj
	private PostRepository repo;

	

	public Post findById(String id) {
		return repo.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object Not Found"));
	}
	
	public List<Post> findByTitle(String text){
		return repo.findByTitleContainingIgnoreCase(text);
	}
}
