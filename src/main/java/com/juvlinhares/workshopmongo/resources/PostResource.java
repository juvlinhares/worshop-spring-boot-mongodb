package com.juvlinhares.workshopmongo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.juvlinhares.workshopmongo.domain.Post;
import com.juvlinhares.workshopmongo.domain.User;
import com.juvlinhares.workshopmongo.dto.UserDTO;
import com.juvlinhares.workshopmongo.services.PostService;

//minha clase vai ser um recurso rest e vai ter um endpoint:
@RestController
@RequestMapping(value="/posts")
public class PostResource {
	
	@Autowired
	private PostService service;
	
	@RequestMapping(value= "/{id}", method = RequestMethod.GET)
	private ResponseEntity<Post> findById(@PathVariable String id){
		Post obj = service.findById(id);		
		return ResponseEntity.ok().body(obj);
	}
	
}
