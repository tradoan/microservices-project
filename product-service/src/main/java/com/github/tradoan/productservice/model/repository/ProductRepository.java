package com.github.tradoan.productservice.model.repository;

import com.github.tradoan.productservice.model.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findByName(String name);
}
