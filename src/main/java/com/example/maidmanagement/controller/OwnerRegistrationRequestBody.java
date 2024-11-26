package com.example.maidmanagement.controller;

public class OwnerRegistrationRequestBody {

        private String username;
        private String password;
        private String name;
        private String houseno;
        private String mobileno;
        private String pincode;


        // Getters and setters
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

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getHouseno() {
            return houseno;
        }

        public void setHouseno(String houseNo) {
            this.houseno = houseNo;
        }

        public String getMobileno() {
            return mobileno;
        }

        public void setMobileno(String mobileNo) {
            this.mobileno = mobileno;
        }

        public String getPincode() {
            return pincode;
        }

        public void setPincode(String pincode) {
            this.pincode = pincode;
        }


    }
