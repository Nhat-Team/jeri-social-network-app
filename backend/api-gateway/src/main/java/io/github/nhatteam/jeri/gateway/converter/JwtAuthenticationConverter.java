package io.github.nhatteam.jeri.gateway.converter;

import lombok.NonNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtClaimNames;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

@Component
public class JwtAuthenticationConverter implements Converter<Jwt, Mono<AbstractAuthenticationToken>> {

    JwtGrantedAuthoritiesConverter jwtGrantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();

    @Override
    public Mono<AbstractAuthenticationToken> convert(Jwt jwt) {
        List<GrantedAuthority> authorities = Stream.concat(jwtGrantedAuthoritiesConverter.convert(jwt).stream(), extractResourceRoles(jwt).stream()).toList();
        return Mono.just(new JwtAuthenticationToken(jwt, authorities, getPrincipleClaimName(jwt)));
    }

    private String getPrincipleClaimName(@NonNull Jwt jwt) {
        String claimName = JwtClaimNames.SUB;
        if(jwt.getClaim("sub") != null) {
            claimName = "sub";
        }
        return jwt.getClaim(claimName).toString();
    }


    private Collection<? extends GrantedAuthority> extractResourceRoles(@NonNull Jwt jwt) {
        Map<String,Object> resourceAccess;
        Collection<String> roles;

        if(jwt.getClaim("realm_access") == null) {
            return Set.of();
        }

        resourceAccess = jwt.getClaim("realm_access");
        if(resourceAccess.get("roles") == null) {
            return Set.of();
        }
        roles = (Collection<String>) resourceAccess.get("roles");

        return roles.stream().map(role -> new SimpleGrantedAuthority("ROLE_" + role)).toList();
    }
}
