package com.github.tradoan.basketservice.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    Long id;
    String name;
    String description;
    Double price;
}
