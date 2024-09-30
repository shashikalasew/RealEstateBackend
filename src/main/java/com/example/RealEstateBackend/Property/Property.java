package com.example.RealEstateBackend.Property;

import com.example.RealEstateBackend.Owner.Owner;
import com.example.RealEstateBackend.PropertyType.PropertyType;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "prop_type_id")
    private PropertyType propertyType;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    private int size;
    private int price;
    private String address;
    private int bedrooms;
    private int bathrooms;
    private int age;
    private boolean balcony;
    private boolean pool;
    private boolean backyard;
    private boolean garage;
    private String description;
}
