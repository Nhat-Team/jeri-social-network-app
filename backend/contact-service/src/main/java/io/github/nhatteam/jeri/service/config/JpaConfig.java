package io.github.nhatteam.jeri.service.config;

import io.github.nhatteam.project.core.security.SecurityAuditUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Optional;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAwareImpl")
@EnableJpaRepositories(basePackages = {"io.github.nhatteam.jeri.service.repository.sql"})
public class JpaConfig {

    @Bean
    public AuditorAware<String> auditorAwareImpl() {
        return new AuditorAware<String>() {
            @Override
            public Optional<String> getCurrentAuditor() {
                return SecurityAuditUtils.getCurrentAuditor();
            }
        };
    }
}
