package io.github.nhatteam.jeri.service.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoAuditing
@EnableMongoRepositories(basePackages = {"io.github.tdminhnhat.jeri.service.repository.mongodb"})
public class MongoConfig {
}
