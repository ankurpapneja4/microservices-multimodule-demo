package com.example.demoapp.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor @AllArgsConstructor @Builder
public class BeerDTO {

    private UUID id;

    private Integer version;

    private OffsetDateTime createdDate;

    private OffsetDateTime lastModifiedDate;

    private String beerName;

    private BeerStyleEnum beerStyle;

    private String upc;

    private BigDecimal price;

    private Integer quantityOnHand;
}
