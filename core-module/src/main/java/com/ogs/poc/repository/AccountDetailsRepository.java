package com.ogs.poc.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.ogs.poc.beans.AccountDetails;

public interface AccountDetailsRepository extends MongoRepository<AccountDetails, Long> {

}
