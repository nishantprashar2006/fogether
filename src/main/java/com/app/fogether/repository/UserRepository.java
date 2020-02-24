package com.app.fogether.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.app.fogether.domain.UserSignup;

@Repository
public interface UserRepository extends MongoRepository<UserSignup, Long>{

}
