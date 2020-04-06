package com.andsotra.microservice.file.storage.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.andsotra.microservice.file.storage.model.Files;

@Repository
public interface FileRepository extends MongoRepository<Files, String>{

}
