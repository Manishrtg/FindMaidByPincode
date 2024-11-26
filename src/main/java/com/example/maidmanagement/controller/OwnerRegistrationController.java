package com.example.maidmanagement.controller;

import com.example.maidmanagement.model.Maid;
import com.example.maidmanagement.model.Owner;
import com.example.maidmanagement.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class OwnerRegistrationController {

    @Autowired
    private OwnerService ownerService;

    @GetMapping("/owner/register")
    public String showRegistrationForm() {
        return "owner_registration";
    }

    @PostMapping("/owner/register")
    public String registerOwner(@RequestBody OwnerRegistrationRequestBody ownerRegistrationRequestBody)
    {
       Owner owner = ownerService.registerOwner(
               ownerRegistrationRequestBody.getUsername(),
               ownerRegistrationRequestBody.getPassword(),
               ownerRegistrationRequestBody.getName(),
               ownerRegistrationRequestBody.getHouseno(),
               ownerRegistrationRequestBody.getMobileno(),
               ownerRegistrationRequestBody.getPincode()
       );

        // Redirect to login page after successful registration
        return "Congrats";
    }
}

