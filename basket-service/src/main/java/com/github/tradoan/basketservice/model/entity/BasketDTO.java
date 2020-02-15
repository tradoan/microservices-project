package com.github.tradoan.basketservice.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BasketDTO{
    Long id;
    Integer quantity;
    Product product;
}
