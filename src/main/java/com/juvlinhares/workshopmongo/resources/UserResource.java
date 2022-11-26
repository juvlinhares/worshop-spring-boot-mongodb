package com.juvlinhares.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.juvlinhares.workshopmongo.domain.User;
import com.juvlinhares.workshopmongo.services.UserService;

//minha clase vai ser um recurso rest e vai ter um endpoint:
@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	//metodo teste de retorno de usuários inseridos
	@RequestMapping(method = RequestMethod.GET)
	private ResponseEntity<List<User>> findAll(){
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}
