package com.example.maidmanagement.controller;

import com.example.maidmanagement.dto.MaidSummaryDTO;
import com.example.maidmanagement.model.Maid;
import com.example.maidmanagement.service.MaidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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
    // GET endpoint to find maids by pincode
    @GetMapping("/find-maids-by-pincode")
    public ResponseEntity<List<MaidSummaryDTO>> findMaidByPincode(@RequestParam String pincode,
                                                                  @RequestParam String userName) {

        List<MaidSummaryDTO> maids = maidService.findMaidsByPincode(userName, pincode);

        // If no maids are found, return 404
        if (maids.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(maids);
        }

        // Return the list of MaidSummaryDTOs
        return ResponseEntity.ok(maids);
    }
}
