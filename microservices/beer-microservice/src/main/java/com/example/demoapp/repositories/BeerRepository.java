package com.example.demoapp.repositories;

import com.example.demoapp.domain.model.Beer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BeerRepository extends  JpaRepository<Beer, UUID>{
}
