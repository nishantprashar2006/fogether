package com.app.fogether.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.app.fogether.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, Long>{

}
