package com.juvlinhares.workshopmongo.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.juvlinhares.workshopmongo.services.exception.ObjectNotFoundException;

//classe manipuladora de exceções na camada de resource

@ControllerAdvice
public class ResourceExceptionHandler {

	//esse método vai tratar a exceção ObjectNotFoundException
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
		
		HttpStatus status= HttpStatus.NOT_FOUND;
												//timespan, status, error, message, path
		StandardError err = new StandardError(System.currentTimeMillis(), status.value(),"Not Found", e.getMessage(), request.getRequestURI());
		//o retorno não vai ser o ok,mas o status pra que eu possa controlar manualmente o status que eu quero retornar.
		
		return ResponseEntity.status(status).body(err);
	}
}
