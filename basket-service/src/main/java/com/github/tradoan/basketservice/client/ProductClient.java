package com.github.tradoan.basketservice.client;

import com.github.tradoan.basketservice.model.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("product-service")
public interface ProductClient {
    @GetMapping("products/{id}")
    Product getProductById(@PathVariable("id") Long id);
}
