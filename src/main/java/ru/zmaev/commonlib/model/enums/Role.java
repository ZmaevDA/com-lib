package ru.zmaev.commonlib.model.enums;

public enum Role {
    ROLE_ADMIN("admin"),
    ROLE_USER("user"),
    ROLE_EDITOR("editor");

    private final String keycloakRoleName;

    Role(String keycloakRoleName) {
        this.keycloakRoleName = keycloakRoleName;
    }

    public String getKeycloakRoleName() {
        return keycloakRoleName;
    }
}
