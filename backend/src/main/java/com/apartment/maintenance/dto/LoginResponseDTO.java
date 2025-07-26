package com.apartment.maintenance.dto;

public class LoginResponseDTO {
    private String message;
    private String role;
    private String email;
    private String fullName;
    private Long userId;

    public LoginResponseDTO() {
    }

    public LoginResponseDTO(String message, String role, String email, String fullName, Long userId) {
        this.message = message;
        this.role = role;
        this.email = email;
        this.fullName = fullName;
        this.userId = userId;
    }

    // Getters and setters

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
