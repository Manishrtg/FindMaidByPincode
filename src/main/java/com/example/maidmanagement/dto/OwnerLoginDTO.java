package com.example.maidmanagement.dto;

public class OwnerLoginDTO {


    private LoginRequest loginRequest;
    private LoginResponse loginResponse;

    // Constructor for response
    public OwnerLoginDTO(LoginResponse loginResponse) {
        this.loginResponse = loginResponse;
    }

    // Constructor for request
    public OwnerLoginDTO(LoginRequest loginRequest) {
        this.loginRequest = loginRequest;
    }

    // Getters and Setters
    public LoginRequest getLoginRequest() {
        return loginRequest;
    }

    public void setLoginRequest(LoginRequest loginRequest) {
        this.loginRequest = loginRequest;
    }

    public LoginResponse getLoginResponse() {
        return loginResponse;
    }

    public void setLoginResponse(LoginResponse loginResponse) {
        this.loginResponse = loginResponse;
    }

    // Nested class for LoginRequest
    public static class LoginRequest {
        private String username;
        private String password;

        // Getters and Setters
        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

    // Nested class for LoginResponse
    public static class LoginResponse {
        private String message;

        public LoginResponse(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
