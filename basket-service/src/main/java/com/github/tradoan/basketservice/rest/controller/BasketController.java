package com.github.tradoan.basketservice.rest.controller;

import com.github.tradoan.basketservice.model.entity.Basket;
import com.github.tradoan.basketservice.model.entity.BasketDTO;
import com.github.tradoan.basketservice.model.entity.Product;
import com.github.tradoan.basketservice.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/basket")
@Profile("h2")
public class BasketController {
    @Autowired
    private BasketService basketService;

    public BasketController(BasketService basketService) {
        this.basketService = basketService;
    }

    @PostMapping("/user/{user_id}")
    public Basket addProductForUser(@PathVariable("user_id") Long id, @RequestBody Basket basketLine) {
        return basketService.addNewProductItemForUser(id, basketLine);
    }

    @DeleteMapping("/user/{user_id}/{product_id}")
    public String deleteProductForUser(@PathVariable("user_id") Long id, @PathVariable("product_id") Long productId) {
        basketService.deleteProductItem(id, productId);
        return "Deleted";
    }

    @PutMapping("/user/{user_id}")
    public Basket updateBasketForUser(@PathVariable("user_id") Long userId, @RequestBody Basket basket) {
        return basketService.updateProductItemForUser(userId, basket);
    }

    @GetMapping("/product/{product_id}")
    public Product getProductForItem(@PathVariable("product_id") Long id) {
        return basketService.getProductFromItem(id);
    }

    @GetMapping("/user/{user_id}/products")
    public List<BasketDTO> getProductsOfUser(@PathVariable("user_id") Long id) {
        return basketService.getProductsForUser(id);
    }
}
