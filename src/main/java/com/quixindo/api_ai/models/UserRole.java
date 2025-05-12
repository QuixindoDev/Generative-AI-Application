package com.quixindo.api_ai.models;

public enum UserRole {
    ADMIN("admin"),
    USER("guest");

    private String role;

    UserRole(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }
}
