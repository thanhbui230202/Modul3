package com.example.case_study_furama_servlet.model;

public class UserRole {
    private Role role_id;
    private User username;

    public UserRole() {
    }

    public UserRole(Role role_id, User username) {
        this.role_id = role_id;
        this.username = username;
    }

    public Role getRole_id() {
        return role_id;
    }

    public void setRole_id(Role role_id) {
        this.role_id = role_id;
    }

    public User getUsername() {
        return username;
    }

    public void setUsername(User username) {
        this.username = username;
    }
}
