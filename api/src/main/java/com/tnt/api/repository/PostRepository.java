package com.tnt.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.tnt.api.domain.Post;

@RepositoryRestResource
public interface PostRepository extends MongoRepository<Post, String> {
}
