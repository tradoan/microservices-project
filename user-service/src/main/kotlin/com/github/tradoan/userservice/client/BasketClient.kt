package com.github.tradoan.userservice.client

import com.github.tradoan.userservice.entity.Basket
import com.github.tradoan.userservice.web.dto.BasketDTO
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*


@FeignClient(name="basket-service")
interface BasketClient {
    @GetMapping("/basket/user/{id}/products")
    fun getProductsOfUser(@PathVariable id: Long) : MutableSet<BasketDTO>

    @PostMapping("/basket/user/{user_id}")
    fun addProductForUser(@PathVariable user_id : Long, @RequestBody basketLine: Basket) : Basket

    @DeleteMapping("/basket/user/{user_id}/{product_id}")
    fun deleteProductForUser(@PathVariable user_id : Long, @PathVariable product_id: Long): String

    @PutMapping("/basket/user/{user_id}")
    fun updateBasketForUser(@PathVariable user_id : Long, @RequestBody basketLine: Basket) : Basket
}
