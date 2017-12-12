package com.spring.data.mongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.spring.data.mongo.Users;

@EnableMongoRepositories
public interface UserRepository extends MongoRepository<Users,String>{
	
	public Optional<Users> findById(String id);

	public void deleteById(String id);
	
	
}
