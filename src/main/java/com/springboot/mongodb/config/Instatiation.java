package com.springboot.mongodb.config;

import com.springboot.mongodb.dto.AuthorDTO;
import com.springboot.mongodb.entities.Post;
import com.springboot.mongodb.entities.User;
import com.springboot.mongodb.repositories.PostRepository;
import com.springboot.mongodb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instatiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "maria@gmail.com", "Maria Brown");
        User alex = new User(null, "alex@gmail.com", "Alex Green");
        User bob = new User(null, "bob@gmail.com", "Bob Grey");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null, sdf.parse("29/04/2026"), "Projeto finalizado", "O projeto blabla foi finalizado", new AuthorDTO(maria));
        Post post2 = new Post(null, sdf.parse("10/03/2018"), "Bom dia", "Bom dia pessoal!", new AuthorDTO(maria));

        postRepository.saveAll(Arrays.asList(post1, post2));

        maria.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(maria);
    }
}
