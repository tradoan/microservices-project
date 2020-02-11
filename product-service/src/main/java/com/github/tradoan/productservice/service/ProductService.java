package com.github.tradoan.productservice.service;

import com.github.tradoan.productservice.model.ProductNotFoundException;
import com.github.tradoan.productservice.model.entity.Product;
import com.github.tradoan.productservice.model.repository.ProductRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService{
    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Iterable<Product> findAllProducts() {
        return this.productRepository.findAll();
    }

    @HystrixCommand(fallbackMethod = "notFoundProductById")
    public Product findProductById(Long id) {
        return this.productRepository.findById(id).get();
    }

    @HystrixCommand(fallbackMethod = "notFoundProductByName")
    public List<Product> findProductByName(String name) {
        return this.productRepository.findByName(name);
    }


    public Product updateProduct(Long id, Product newProduct) {
        newProduct.setId(id);
        return this.productRepository.save(newProduct);
    }

    public void deleteProductById(Long id) {
        this.productRepository.deleteById(id);
    }

    public Product notFoundProductById(Long id) throws ProductNotFoundException {
        throw new ProductNotFoundException("Product id " + id + " not found!");
    }

    public List<Product> notFoundProductByName(String name) {
        return Collections.emptyList();
    }
}
