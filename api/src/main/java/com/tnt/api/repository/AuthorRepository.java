package com.tnt.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.tnt.api.domain.Author;

@RepositoryRestResource
public interface AuthorRepository extends MongoRepository<Author, String> {
}
