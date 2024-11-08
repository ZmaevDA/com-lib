package ru.zmaev.commonlib.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;
import ru.zmaev.commonlib.auth.AuthUtils;
import ru.zmaev.commonlib.model.dto.UserInfo;

@Configuration
public class AuthConfig {
    private final AuthUtils authUtils;

    public AuthConfig(AuthUtils authUtils) {
        this.authUtils = authUtils;
    }

    @Bean
    @Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public UserInfo userInfo() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(AuthUtils.getCurrentUserId());
        userInfo.setJwt(AuthUtils.getJwt());
        userInfo.setUsername(AuthUtils.getUsername());
        userInfo.setRole(AuthUtils.getCurrentRoles());
        return userInfo;
    }
}
