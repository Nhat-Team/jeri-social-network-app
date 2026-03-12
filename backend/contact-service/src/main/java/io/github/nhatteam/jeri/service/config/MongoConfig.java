package io.github.nhatteam.jeri.service.config;

import io.github.nhatteam.project.core.security.SecurityAuditUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoAuditing(auditorAwareRef = "auditorAwareImpl")
@EnableMongoRepositories(basePackages = {"io.github.nhatteam.jeri.service.repository.nosql"})
public class MongoConfig {

    public AuditorAware<String> auditorAwareImpl() {
        return new AuditorAware<String>() {
            @Override
            public java.util.Optional<String> getCurrentAuditor() {
                return SecurityAuditUtils.getCurrentAuditor();
            }
        };
    }
}
