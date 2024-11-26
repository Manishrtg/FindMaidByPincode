package com.example.maidmanagement.controller;

import com.example.maidmanagement.model.Maid;
import com.example.maidmanagement.service.MaidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class MaidRegistrationController {

    @Autowired
    private MaidService maidService;

    @GetMapping("/maid/register")
    public String showRegistrationForm() {
        return "maid_registration";
    }

    @PostMapping("/maid/register")
    public String registerMaid(@RequestBody MaidRegistrationRequestBody maidRegistrationRequestBody) {
        Maid maid = maidService.registerMaid(
                maidRegistrationRequestBody.getUsername(),
                maidRegistrationRequestBody.getPassword(),
                maidRegistrationRequestBody.getName(),
                maidRegistrationRequestBody.getHouseno(),
                maidRegistrationRequestBody.getMobileno(),
                maidRegistrationRequestBody.getPincode(),
                maidRegistrationRequestBody.getAvailableSlots()
        );

        // Redirect to login page after successful registration
        return "Congrats";
    }
}

