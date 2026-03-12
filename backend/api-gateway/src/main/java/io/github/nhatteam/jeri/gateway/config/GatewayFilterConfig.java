package io.github.nhatteam.jeri.gateway.config;

import org.jspecify.annotations.NonNull;
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
    public Mono<Void> filter(ServerWebExchange exchange, @NonNull GatewayFilterChain chain) {
        if(exchange.getRequest().getPath().value().equalsIgnoreCase("/user/api/v1/users/register")) {
            return chain.filter(exchange);
        }

        return exchange.getPrincipal().cast(JwtAuthenticationToken.class).map(jwtToken -> jwtToken.getToken().getSubject()).flatMap(sub -> {
            ServerWebExchange mutatedChanged = exchange.mutate().request(r -> r.header("X-Sub", sub)).build();
            return chain.filter(mutatedChanged);
        });
    }

    @Override
    public int getOrder() {
        return -1;
    }
}
