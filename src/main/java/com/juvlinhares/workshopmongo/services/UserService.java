package com.juvlinhares.workshopmongo.services;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juvlinhares.workshopmongo.domain.User;
import com.juvlinhares.workshopmongo.dto.UserDTO;
import com.juvlinhares.workshopmongo.repository.UserRepository;
import com.juvlinhares.workshopmongo.services.exception.ObjectNotFoundException;

@Service // serviço injetavel em outras classes
public class UserService {

	
	@Autowired // o proprio spring proca e define o obj
	private UserRepository repo;

	public List<User> findAll() {
		return repo.findAll(); // vai no bd e retornar todos os objetos user
	}

	public User findById(String id) {
		return repo.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object Not Found"));
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	

	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public User update(User obj) {

		//instanciar o obj usuário pra buscar ele no bd:
		User newObj = repo.findById(obj.getId()).orElseThrow(()-> new ObjectNotFoundException("object not found"));
		updateData(newObj, obj);
		return repo.save(newObj);
	}
		//método responsavel por copiar os dados de obj p newObj, vinculado ao update.
		private void updateData(User newObj, User obj) {
		 newObj.setName(obj.getName());
		 newObj.setEmail(obj.getEmail());
		
	}

		public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
	
}
