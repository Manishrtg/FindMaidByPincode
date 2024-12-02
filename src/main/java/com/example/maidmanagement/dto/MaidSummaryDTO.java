package com.example.maidmanagement.dto;

public class MaidSummaryDTO {


    private String name;
    private String houseno;
    private String mobileno;
    private String pincode;
    private String availableslots;

    // Constructor
    public MaidSummaryDTO(String name, String houseno, String mobileno, String pincode, String availableslots) {
        this.name = name;
        this.houseno = houseno;
        this.mobileno = mobileno;
        this.pincode = pincode;
        this.availableslots = availableslots;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHouseno() {
        return houseno;
    }

    public void setHouseno(String houseno) {
        this.houseno = houseno;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getAvailableslots() {
        return availableslots;
    }

    public void setAvailableslots(String availableslots) {
        this.availableslots = availableslots;
    }
}
