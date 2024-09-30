package com.example.RealEstateBackend.Sale;

import com.example.RealEstateBackend.Client.Client;
import com.example.RealEstateBackend.Property.Property;
import com.example.RealEstateBackend.User.User;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "property_id")
    private Property property;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private int finalPrice;
    private LocalDateTime sellingDate;
}
