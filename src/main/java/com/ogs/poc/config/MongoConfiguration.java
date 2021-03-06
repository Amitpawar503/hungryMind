package com.ogs.poc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoClientFactoryBean;

@Configuration
public class MongoConfiguration {
	
	 private static final String MONGO_DB_URL = "localhost";
	    private static final String MONGO_DB_NAME = "embeded_db";
	    
	   /* @Bean
	    public MongoTemplate mongoTemplate() throws IOException {
	        EmbeddedMongoFactoryBean mongo = new EmbeddedMongoFactoryBean();
	        mongo.setBindIp(MONGO_DB_URL);
	        MongoClient mongoClient = mongo.getObject();
	        MongoTemplate mongoTemplate = new MongoTemplate(mongoClient, MONGO_DB_NAME);
	        return mongoTemplate;
	        
	        
	    }*/

	    public @Bean MongoClientFactoryBean mongo() {
	          MongoClientFactoryBean mongo = new MongoClientFactoryBean();
	          mongo.setHost("localhost");
	          return mongo;
	     }
}
