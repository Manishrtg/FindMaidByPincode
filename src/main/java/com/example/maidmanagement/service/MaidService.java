package com.example.maidmanagement.service;

import com.example.maidmanagement.model.Maid;
import com.example.maidmanagement.model.Owner;
import com.example.maidmanagement.repository.MaidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class MaidService {

    @Autowired
    private MaidRepository maidRepository;

    @Autowired
    private OwnerService ownerService;

    // Find by Pincode
    public List<Maid> findMaidsByPincode(String ownerId, String pincode) {
        Owner owner = ownerService.findByOwnerId(ownerId);
        if (owner == null) {
            throw new IllegalArgumentException("You are not eligible for this service");
        }
        return maidRepository.findByPincode(pincode);
    }

    // Authen. Maid with username and password
    public Maid authenticateMaid(String username, String password) {
        Maid maid = maidRepository.findByUsername(username);

        // Check if the maid exists and the password matches
        if (maid != null && maid.getPassword().equals(password)) {
            return maid; // Return maid if credentials are correct
        }

        return null; // Return null if credentials don't match
    }

    // Find maids by exact pincode match
    public List<Maid> getMaidsByPincode(String pincode) {
        return maidRepository.findByPincode(pincode);
    }

    // Register a Maid
    public Maid registerMaid(String username, String password, String name, String houseNo, String mobileNo, String pincode, String availableslots) {
        Maid maid = new Maid();
        maid.setUsername(username);
        maid.setPassword(password);  // Storing plain text password
        maid.setName(name);
        maid.setHouseno(houseNo);
        maid.setMobileno(mobileNo);
        maid.setPincode(pincode);
        maid.setAvailableslots(availableslots);
        return maidRepository.save(maid);
    }




}
