package com.github.tradoan.userservice.client

import com.github.tradoan.userservice.entity.Basket
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name="basket-service")
interface BasketClient {
    @GetMapping("/basket/user/{id}/products")
    fun getProductsOfUser(@PathVariable id: Long) : MutableSet<Basket>
}
