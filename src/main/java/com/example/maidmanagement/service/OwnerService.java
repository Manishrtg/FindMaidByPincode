package com.example.maidmanagement.service;

import com.example.maidmanagement.model.Owner;
import com.example.maidmanagement.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;

    public Owner authenticateOwner(String username, String password) {
        Owner owner = ownerRepository.findByUsername(username);  // Fetch owner by username

        // If owner exists and passwords match, return owner
        if (owner != null &&  owner.getPassword().equals(password)) {
            return owner;
        }

        return null;  // Invalid credentials
    }



    // Register an Owner
    public Owner registerOwner(String username, String password, String name, String houseno, String mobileno, String pincode) {
        Owner owner = new Owner();
        owner.setUsername(username);
        owner.setPassword(password);  // Storing plain text pwd
        owner.setName(name);
        owner.setHouseno(houseno);
        owner.setMobileno(mobileno);
        owner.setPincode(pincode);
        return ownerRepository.save(owner);
    }

    public Owner findByOwnerId(String userName) {
        return ownerRepository.findByUsername(userName);  // Return the Owner found by username
    }
}
