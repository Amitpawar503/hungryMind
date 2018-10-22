package com.ogs.poc.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.ogs.poc.beans.RealSet;

public interface RealSetRepository extends MongoRepository<RealSet, Long> {

}
