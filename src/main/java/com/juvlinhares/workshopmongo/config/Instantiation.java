package com.juvlinhares.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.juvlinhares.workshopmongo.domain.Post;
import com.juvlinhares.workshopmongo.domain.User;
import com.juvlinhares.workshopmongo.dto.AuthorDTO;
import com.juvlinhares.workshopmongo.dto.CommentDTO;
import com.juvlinhares.workshopmongo.repository.PostRepository;
import com.juvlinhares.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	// injetar o UserRepository p fazer a operação com o bd:

	@Autowired
	private UserRepository userRepository;// injeção do user repository

	@Autowired
	private PostRepository postRepository;// injeção do user repository

	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		// limpar o bd:
		userRepository.deleteAll();
		postRepository.deleteAll();

		// instanciar o obj e salvar no bd:
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");

		// salvar novos Users no bd
		userRepository.saveAll(Arrays.asList(maria, alex, bob));

		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));

		//instanciar os comentários:
		CommentDTO comment1 = new CommentDTO("Boa viagem mano!", sdf.parse("21/03/2018"), new AuthorDTO(alex));
		CommentDTO comment2 = new CommentDTO("Aproveite!", sdf.parse("22/03/2018"), new AuthorDTO(bob));
		CommentDTO comment3 = new CommentDTO("Tenha um ótimo dia!", sdf.parse("23/03/2018"), new AuthorDTO(alex));
		
		//associação de comentários com posts:
		post1.getComments().addAll(Arrays.asList(comment1, comment2));
		post2.getComments().addAll(Arrays.asList(comment3));
		
		// salvar os posts no bd
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		//referenciar os posts no user:
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(maria);

	}

}
