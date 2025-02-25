package com.example.demo.models;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "tb_tech_list")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TechModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
}
