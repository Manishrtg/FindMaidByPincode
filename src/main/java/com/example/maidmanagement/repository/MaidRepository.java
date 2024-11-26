package com.example.maidmanagement.repository;

import com.example.maidmanagement.model.Maid;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MaidRepository extends JpaRepository<Maid, Long> {
    Maid findByUsername(String username);

}
