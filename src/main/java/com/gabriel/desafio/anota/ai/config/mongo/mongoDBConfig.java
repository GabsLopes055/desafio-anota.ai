package com.gabriel.desafio.anota.ai.config.mongo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

@Configuration
public class mongoDBConfig {

    @Bean
    public MongoDatabaseFactory mongoConfiguration() {
        return new SimpleMongoClientDatabaseFactory("mongodb://localhost:27017/products-catalog");
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoConfiguration());
    }


}
