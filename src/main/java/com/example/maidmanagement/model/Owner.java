package com.example.maidmanagement.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data

@Table(name="owner")

public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String name;
    private String houseno;
    private String mobileno;
    private String pincode;
}
