package com.app.fogether.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.app.fogether.domain.DatabaseSequence;

@Repository
public interface SequenceGeneratorRepository extends MongoRepository<DatabaseSequence, String>{


}
