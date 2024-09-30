package com.example.RealEstateBackend.Sale;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SaleDTO {

    @JsonProperty("property_id")
    private int propertyId;

    @JsonProperty("client_id")
    private int clientId;

    @JsonProperty("user_id")
    private int userId;

    @JsonProperty("final_price")
    private int finalPrice;
}
