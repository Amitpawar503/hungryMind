package com.ogs.poc.coremodule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = {"com.ogs.poc"})
@EnableMongoRepositories ("com.ogs.poc.repository")
//@EnableAutoConfiguration(exclude = { MongoAutoConfiguration.class}) 
public class CoreModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoreModuleApplication.class, args);
	}
}
