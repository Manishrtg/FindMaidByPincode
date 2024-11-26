package com.example.maidmanagement.dto;

public class MaidLoginDTO {


    // Request Class (LoginRequest)
    private LoginRequest loginRequest;
    // Response Class (LoginResponse)
    private LoginResponse loginResponse;

    // Constructors
    public MaidLoginDTO(LoginResponse loginResponse) {
        this.loginResponse = loginResponse;
    }

    public MaidLoginDTO(LoginRequest loginRequest) {
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

    // Nested class (Request Class)
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

    // Nested class (Response Class)
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

