package ru.zmaev.commonlib.auth;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;
import ru.zmaev.commonlib.model.enums.Role;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Component
public class AuthUtils {

    public static String getCurrentUserId() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    public static String getJwt() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof Jwt) {
            Jwt jwt = (Jwt) authentication.getPrincipal();

            String token = jwt.getTokenValue();
            return token;
        }
        return null;
    }

    public static String getUsername() {
        Object principalObject = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        try {
            Jwt jwt = (Jwt) principalObject;
            return jwt.getClaim("preferred_username");
        } catch (ClassCastException e) {
            UserDetails userDetails = (UserDetails) principalObject;
            return userDetails.getUsername();
        }
    }

    public static List<String> getCurrentRoles() {
        Jwt jwt = (Jwt) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Map<String, Object> realmAccess = jwt.getClaims();
        Map<String, List<String>> rolesMapFromJwt = (Map<String, List<String>>) realmAccess.get("realm_access");
        List<String> allowedRoles = Arrays.stream(Role.values()).map(Enum::toString).toList();
        List<String> roles = rolesMapFromJwt.get("roles");
        roles = roles.stream().map(role -> "ROLE_" + role.toUpperCase()).filter(allowedRoles::contains).toList();
        return roles;
    }

    public static boolean getIsDeleted() {
        Jwt jwt = (Jwt) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Map<String, Object> realmAccess = jwt.getClaims();
        return (Boolean) realmAccess.get("isDeleted");
    }
}
