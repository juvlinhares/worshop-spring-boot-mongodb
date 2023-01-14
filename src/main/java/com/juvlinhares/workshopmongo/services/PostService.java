package com.juvlinhares.workshopmongo.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juvlinhares.workshopmongo.domain.Post;
import com.juvlinhares.workshopmongo.repository.PostRepository;
import com.juvlinhares.workshopmongo.services.exception.ObjectNotFoundException;

@Service // serviço injetavel em outras classes
public class PostService {

	
	@Autowired // o proprio spring proca e define o obj
	private PostRepository repo;

	

	public Post findById(String id) {
		return repo.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object Not Found"));
	}
	
	public List<Post> findByTitle(String text){
		return repo.searchTitle(text);
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate){
		/*a data maxima não pode ser no início do ultimo dia, mas sim no fim,
		 então a data maxima vai ser ela mesma + um dia*/
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);//24 * 60 * 60 * 1000 => 1 dia a mais em milissegundos
		return repo.fullSerach(text, minDate, maxDate);
	}
}
