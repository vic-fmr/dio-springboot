package com.example.demo.repositories;

import com.example.demo.models.TechModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechRepository extends JpaRepository<TechModel, Long> {
}
