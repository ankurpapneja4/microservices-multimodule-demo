package com.exapmple.demoapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor @AllArgsConstructor @Builder
@Entity
public class Customer {

    @Id
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
}
