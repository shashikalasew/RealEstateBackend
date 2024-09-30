package com.example.RealEstateBackend.Property;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PropertyDTO {

    @JsonProperty("prop_type_id")
    private int propTypeId;

    @JsonProperty("owner_id")
    private int ownerId;

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
