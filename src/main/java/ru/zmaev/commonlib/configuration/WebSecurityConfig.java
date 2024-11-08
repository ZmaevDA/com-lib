package ru.zmaev.commonlib.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.AuthorizationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import ru.zmaev.commonlib.auth.filter.CustomJwtFilter;
import ru.zmaev.commonlib.jwt.JwtAuthConverter;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig {

    private final JwtAuthConverter jwtAuthConverter;

    public WebSecurityConfig(JwtAuthConverter jwtAuthConverter) {
        this.jwtAuthConverter = jwtAuthConverter;
    }

    @Bean
    @Primary
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.cors(Customizer.withDefaults())
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize ->
                        authorize
                                .requestMatchers("/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui/index.html")
                                .permitAll()
                                .requestMatchers("/api/character/start-class")
                                .permitAll()
                                .requestMatchers("/api/user/{spring:[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}}/recovery")
                                .permitAll()
                                .requestMatchers(
                                        new AntPathRequestMatcher("api/build/**", HttpMethod.GET.name()))
                                .permitAll()
                                .requestMatchers(
                                        new AntPathRequestMatcher("api/weapon/**", HttpMethod.GET.name()))
                                .permitAll()
                                .requestMatchers(
                                        new AntPathRequestMatcher("api/inventory-item/**", HttpMethod.GET.name()))
                                .permitAll()
                                .requestMatchers("api/auth/register")
                                .permitAll()
                                .anyRequest().authenticated()
                )
                .addFilterBefore(new CustomJwtFilter(), AuthorizationFilter.class)
                .oauth2ResourceServer(oauth2 ->
                        oauth2.jwt(jwt -> jwt.jwtAuthenticationConverter(jwtAuthConverter))
                )
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        return http.build();
    }
}

