package com.example.RealEstateBackend.Owner;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String phone;

    @Column(unique = true)
    private String email;

    private String address;
    private LocalDateTime createdAt;
}
