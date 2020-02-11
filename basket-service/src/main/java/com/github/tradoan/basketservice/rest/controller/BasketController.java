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

    @GetMapping("/user/{user-id}")
    public List<Basket> getAllProductItemsByUser(@PathVariable("user-id") Long id) {
       return basketService.getBasketsByUserId(id);
    }

    @PostMapping("/user/{user-id}")
    public Basket addProductForUser(@PathVariable("user-id") Long id, @RequestBody Basket basket) {
        return basketService.addNewProductItemForUser(id, basket);
    }

    @DeleteMapping("/user/{user-id}/{product-id}")
    public void deleteProductForUser(@PathVariable("user-id") Long id, @PathVariable("product-id") Long productId) {
        basketService.deleteProductItem(id, productId);
    }

    @PutMapping("/user/{user-id}")
    public Basket updateBasketForUser(@PathVariable("user-id") Long userId, @RequestBody Basket basket) {
        return basketService.updateProductItemForUser(userId, basket);
    }

    @DeleteMapping("/delete")
    public void deleteItem(@RequestBody Basket basket) {
        basketService.deleteProductItem(basket.getUserId(), basket.getProductId());
    }

    @GetMapping("/{item-id}/product/")
    public Product getProductForItem(@PathVariable("item-id") Long id) {
        return basketService.getProductFromItem(id);
    }

    @GetMapping("/user/{user-id}/products")
    public List<BasketDTO> getProductsOfUser(@PathVariable("user-id") Long id) {
        return basketService.getProductsForUser(id);
    }
}
