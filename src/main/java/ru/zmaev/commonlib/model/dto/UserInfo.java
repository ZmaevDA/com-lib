package ru.zmaev.commonlib.model.dto;

import java.util.List;

public class UserInfo {
    private String userId;
    private String jwt;
    private String username;
    private Boolean isDeleted;
    private List<String> role;

    public UserInfo(String userId, String jwt, String username, Boolean isDeleted, List<String> role) {
        this.userId = userId;
        this.jwt = jwt;
        this.username = username;
        this.isDeleted = isDeleted;
        this.role = role;
    }

    public UserInfo() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public List<String> getRole() {
        return role;
    }

    public void setRole(List<String> role) {
        this.role = role;
    }
}