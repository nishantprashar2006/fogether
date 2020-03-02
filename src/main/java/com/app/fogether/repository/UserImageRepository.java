package com.app.fogether.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.app.fogether.domain.UserImage;

public interface UserImageRepository extends MongoRepository<UserImage, Long>{

}
