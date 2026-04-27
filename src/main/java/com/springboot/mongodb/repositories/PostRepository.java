package com.springboot.mongodb.repositories;

import com.springboot.mongodb.entities.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {
}
