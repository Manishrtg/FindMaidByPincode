package com.example.maidmanagement.service;

import com.example.maidmanagement.dto.MaidSummaryDTO;
import com.example.maidmanagement.model.Maid;
import com.example.maidmanagement.model.Owner;
import com.example.maidmanagement.repository.MaidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class MaidService {

    @Autowired
    private MaidRepository maidRepository;

    @Autowired
    private OwnerService ownerService;



    // Modify this method to return a list of MaidSummaryDTO
    public List<MaidSummaryDTO> findMaidsByPincode(String ownerId, String pincode) {
        // Assuming owner validation is already handled
        List<Maid> maids = maidRepository.findByPincode(pincode);

        // Convert the list of Maid objects to MaidSummaryDTO objects
        List<MaidSummaryDTO> maidSummaryDTOs = maids.stream().map(maid ->
                new MaidSummaryDTO(
                        maid.getName(),
                        maid.getHouseno(),
                        maid.getMobileno(),
                        maid.getPincode(),
                        maid.getAvailableslots()
                )
        ).collect(Collectors.toList());

        return maidSummaryDTOs;
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
