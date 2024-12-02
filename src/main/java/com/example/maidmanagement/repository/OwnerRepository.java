package com.example.maidmanagement.repository;

import com.example.maidmanagement.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
    Owner findByUsername(String username);
    List<Owner> findByusername(String username);
}

