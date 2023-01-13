package com.juvlinhares.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.juvlinhares.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

	//metodo encontra pelo título, o spring data ja monta a consulta.
	List<Post> findByTitleContainingIgnoreCase(String text);
}
