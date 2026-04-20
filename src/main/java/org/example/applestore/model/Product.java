package org.example.applestore.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,unique = true)
    private String name;
    private String model;
    private String color;
    private String display;
    private String camera;
    private String chip;
    private String storage;
    private String waterresistense;
    private LocalDateTime createddate = LocalDateTime.now();
    private String category;
    private String price;
}
