package com.juvlinhares.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.juvlinhares.workshopmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
