package com.github.tradoan.productservice.rest.controller;

import com.github.tradoan.productservice.model.entity.Product;
import com.github.tradoan.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public Iterable<Product> getAllProducts(){
        return this.productService.findAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id){
        return this.productService.findProductById(id);
    }

    @GetMapping("/name/{name}")
    public List<Product> getProductByName(@PathVariable("name") String name){
        return this.productService.findProductByName(name);
    }


/*
    @GetMapping("/customer/{customer-id}")
    public List<Product> getProductsByCustomer(@PathVariable("customer-id") Long customerId) {
        return productService.findProductsByCustomer(customerId);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
    }

 */
}
