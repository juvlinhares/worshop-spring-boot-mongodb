package com.juvlinhares.workshopmongo.resources;

import java.util.List;import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.juvlinhares.workshopmongo.domain.User;
import com.juvlinhares.workshopmongo.dto.UserDTO;
import com.juvlinhares.workshopmongo.services.UserService;

//minha clase vai ser um recurso rest e vai ter um endpoint:
@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	//metodo teste de retorno de usuários inseridos
	@RequestMapping(method = RequestMethod.GET)
	private ResponseEntity<List<UserDTO>> findAll(){
		List<User> list = service.findAll();
								//percorre, cria um userdto, coleta e retorna como lista 
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
}
