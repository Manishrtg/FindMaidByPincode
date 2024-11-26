package com.example.maidmanagement.service;

import com.example.maidmanagement.model.Maid;
import com.example.maidmanagement.repository.MaidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MaidService {

    @Autowired
    private MaidRepository maidRepository;


    // Authen. Maid with username and password
    public Maid authenticateMaid(String username, String password) {
        Maid maid = maidRepository.findByUsername(username);

        // Check if the maid exists and the password matches
        if (maid != null && maid.getPassword().equals(password)) {
            return maid; // Return maid if credentials are correct
        }

        return null; // Return null if credentials don't match
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

//    // Authenticate Maid with plain text password
//    public boolean authenticateMaid(String username, String password) {
//        Maid maid = maidRepository.findByUsername(username);
//        return maid != null && maid.getPassword().equals(password);  // Compare plain text password
//    }
//
//    // Find maids by exact pincode match
//    public List<Maid> findMaidsByPincode(String pincode) {
//        return maidRepository.findByPincode(pincode);
//    }


//
//    public boolean authenticateMaid(String username, String password) {
//        String sql = "SELECT name FROM maids WHERE username = ? AND password = ?";  // Query to check credentials
//        try {
//            // Query for the maid's name based on provided username and password
//            String userName = jdbcTemplate.queryForObject(sql, new Object[]{username, password}, String.class);
//            return userName != null;  // If user found, authentication successful
//        } catch (Exception e) {
//            // If no user found or error occurs, authentication fails
//            return false;
//        }
//    }

//  public boolean authenticateMaid(String username, String password) {
//        String sql = "SELECT name FROM maids WHERE username = ? AND password = ?";  // SQL query to check credentials
//        try {
//            // Query for the maid's name based on provided username and password
//            String userName = jdbcTemplate.queryForObject(sql, new Object[]{username, password}, String.class);
//            return userName != null;  // If a user is found, authentication is successful
//        } catch (Exception e) {
//            // If no user is found or any exception occurs, authentication fails
//            return false;
//        }




}
