package org.example.applestore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

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
