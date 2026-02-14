package io.github.nhatteam.jeri.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouterConfig {

    @Bean
    public RouteLocator routeConfig(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("user-service",p -> p.path("/user/**").uri("lb://user-service/user"))
                .route("friend-service",p -> p.path("/friend/**").uri("lb://friend-service/friend"))
                .route("chat-service",p -> p.path("/chat/**").uri("lb://chat-service/chat"))
                .route("feed-service",p -> p.path("/feed/**").uri("lb://feed-service/feed"))
                .build();
    }
}
