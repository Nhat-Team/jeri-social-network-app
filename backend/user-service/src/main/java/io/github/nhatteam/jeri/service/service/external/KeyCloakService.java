package io.github.nhatteam.jeri.service.service.external;

import io.github.nhatteam.jeri.service.entity.User;
import io.github.nhatteam.jeri.service.model.dto.AccountLogin;
import io.github.nhatteam.jeri.service.model.dto.AccountResetPasswordDto;
import io.github.nhatteam.jeri.service.model.dto.UserDto;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClient;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class KeyCloakService {

    private final RestClient restClient = RestClient.create();

    @NonFinal
    @Value("${spring.security.oauth2.resourceserver.jwt.default-path}")
    private String keycloakPath;

    @NonFinal
    @Value("${spring.security.oauth2.resourceserver.jwt.realm}")
    private String realm;

    @NonFinal
    @Value("${spring.security.oauth2.resourceserver.jwt.admin-username}")
    private String adminUsername;

    @NonFinal
    @Value("${spring.security.oauth2.resourceserver.jwt.admin-password}")
    private String adminPassword;

    public Map<String, Object> loginAccount(AccountLogin request) {
        String path = keycloakPath + "/realms/${KEYCLOAK_REALM}/protocol/openid-connect/token".replace("${KEYCLOAK_REALM}", realm);
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>() {{
            add("client_id", "jeri-app-chat-client");
            add("username", request.username());
            add("password", request.password());
            add("grant_type", "password");
        }};

        return restClient.post().uri(path).header("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE).body(params).retrieve().body(Map.class);
    }

    public void createUser(UserDto request) throws Exception {
        String path = keycloakPath + "/admin/realms/${KEYCLOAK_REALM}/users".replace("${KEYCLOAK_REALM}", realm);
        String token = loginAccount(new AccountLogin(adminUsername, adminPassword)).get("access_token").toString();

        Map<String, Object> body = Map.of(
                "username", request.username(),
                "firstName", request.firstName(),
                "lastName", request.lastName(),
                "email", request.email(),
                "enabled", true,
                "credentials", new ArrayList<Map<String, Object>>() {{
                    add(new HashMap<>() {{
                        put("type", "password");
                        put("value", request.password());
                        put("temporary", false);
                    }});
                }}
        );

        ResponseEntity<Void> response = restClient.post()
                .uri(path)
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                .body(body)
                .retrieve()
                .toBodilessEntity();

        if (response.getStatusCode().value() >= 400) {
            throw new Exception("Failed to create user in Keycloak");
        }
    }

    public void updateUser(User entity) {
        String path = keycloakPath + "/admin/realms/${KEYCLOAK_REALM}/users/${USER_ID}".replace("${KEYCLOAK_REALM}", realm).replace("${USER_ID}", entity.getUserId());
        String token = loginAccount(new AccountLogin(adminUsername, adminPassword)).get("access_token").toString();

        Map<String,Object> body = Map.of(
                "username", entity.getUsername(),
                "firstName", entity.getFirstName(),
                "lastName", entity.getLastName(),
                "email", entity.getEmail()
        );

        ResponseEntity<Void> response = restClient.put().uri(path).header("Authorization", "Bearer " + token).header("Content-Type", MediaType.APPLICATION_JSON_VALUE).body(body).retrieve().toBodilessEntity();

        if(response.getStatusCode().value() >= 400) {
            throw new RuntimeException("Failed to update user in Keycloak");
        }
    }

    public boolean resetPassword(AccountResetPasswordDto request) {
        String path = keycloakPath + "/admin/realms/${KEYCLOAK_REALM}/users/${USER_ID}/reset-password".replace("${KEYCLOAK_REALM}", realm).replace("${USER_ID}", getUserId(request.username()));
        String token = loginAccount(new AccountLogin(adminUsername, adminPassword)).get("access_token").toString();

        Map<String, Object> body = Map.of(
                "type", "password",
                "value", request.password(),
                "temporary", false
        );

        ResponseEntity<Void> response = restClient.put().uri(path).header("Authorization", "Bearer " + token).header("Content-Type", MediaType.APPLICATION_JSON_VALUE).body(body).retrieve().toBodilessEntity();

        return response.getStatusCode().value() < 400;
    }

    public String getUserId(String username) {
        String path = keycloakPath + "/admin/realms/${KEYCLOAK_REALM}/users?username=${USERNAME}".replace("${KEYCLOAK_REALM}", realm).replace("${USERNAME}", username);
        String token = loginAccount(new AccountLogin(adminUsername, adminPassword)).get("access_token").toString();

        List<Map<String,Object>> users = restClient.get().uri(path).header("Authorization", "Bearer " + token).retrieve().body(new ParameterizedTypeReference<List<Map<String, Object>>>(){});
        return users.getFirst().get("id").toString();
    }
}
