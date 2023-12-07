package com.example.demoapp.domain.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Beer {

    @Id
    @GeneratedValue( strategy = GenerationType.UUID )
    @Column( length = 36, columnDefinition = "char(36)", updatable = false , nullable = false )
    private UUID id;

    @Version
    private Integer version;

    @CreationTimestamp
    @Column( updatable=false )
    private OffsetDateTime createdDate;

    @UpdateTimestamp
    private OffsetDateTime lastModifiedDate;

    private String beerName;

    private String beerStyle;

    @Column( unique = true )
    private String upc;

    private BigDecimal price;

    private Integer minOnHand;
    private Integer quantityToBrew;
}
