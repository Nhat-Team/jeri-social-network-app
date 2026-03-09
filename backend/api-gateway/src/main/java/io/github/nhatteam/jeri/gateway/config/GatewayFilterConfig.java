package io.github.nhatteam.jeri.gateway.config;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Configuration
public class GatewayFilterConfig implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String header = exchange.getRequest().getHeaders().getFirst("Authorization");

        if(exchange.getRequest().getPath().value().equals("/user/api/v1/auth/login") || exchange.getRequest().getPath().value().equals("/user/api/v1/auth/register")) {
            return chain.filter(exchange);
        }

        if(header == null || !header.startsWith("Bearer ")) {
            exchange.getResponse().setStatusCode(org.springframework.http.HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }

        exchange.getPrincipal().cast(JwtAuthenticationToken.class).map(jwtToken -> jwtToken.getToken().getSubject()).flatMap(sub -> {
            exchange.getRequest().mutate().header("X-Sub", sub).build();
            return chain.filter(exchange);
        });

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return -1;
    }
}
