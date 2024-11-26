package com.example.maidmanagement.repository;

import com.example.maidmanagement.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
    Owner findByUsername(String username);
}
