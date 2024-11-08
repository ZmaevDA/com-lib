package ru.zmaev.commonlib.configuration;

import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KeycloakAdminConfig {

    @Bean
    public Keycloak keycloak(
            @Value("${keycloak.server-url}") String serverUrl,
            @Value("${keycloak.realm}") String realm,
            @Value("${keycloak.resource}") String clientId,
            @Value("${keycloak.username}") String username,
            @Value("${keycloak.client-secret}") String secret,
            @Value("${keycloak.password}") String password
    ) {
        return KeycloakBuilder.builder()
                .serverUrl(serverUrl)
                .realm(realm)
                .clientId(clientId)
                .clientSecret(secret)
                .username(username)
                .password(password)
                .build();
    }
}

