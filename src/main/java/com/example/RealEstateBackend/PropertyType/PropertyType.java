package com.example.RealEstateBackend.PropertyType;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class PropertyType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String description;
}
