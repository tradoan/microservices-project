package com.github.tradoan.userservice.web.controller

import com.github.tradoan.userservice.entity.Basket
import com.github.tradoan.userservice.entity.User
import com.github.tradoan.userservice.sevice.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/user")
class UserController(private val userService: UserService) {

    @GetMapping("/{id}")
    fun getUser(@PathVariable id: Long) = ResponseEntity.ok(this.userService.getUserById(id))

    @GetMapping("/{id}/basket")
    fun getProductItemsForUser(@PathVariable id: Long) = ResponseEntity.ok(userService.getItemsForUser(id))

    @PostMapping
    fun createNewUser(@RequestBody user: User) = ResponseEntity.status(HttpStatus.CREATED)
            .body(userService.createNewUser(user))

    @PutMapping("/{id}")
    fun updateUser(@PathVariable id: Long, @RequestBody user: User) =
            ResponseEntity.ok(userService.editUser(user, id))

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: Long) = ResponseEntity.ok(userService.deleteUser(id))

    @PostMapping("/login")
    fun login(@RequestBody user: User) = ResponseEntity.ok(userService.login(user))

    @PostMapping("/{id}/basket")
    fun addProductIntoBasket(@PathVariable id: Long, @RequestBody basketLine: Basket) = userService.addProductIntoBasket(id, basketLine)

    @PutMapping("/{id}/basket")
    fun updateBasketLine(@PathVariable id: Long, @RequestBody basketLine: Basket) = userService.editBasketLine(id, basketLine)

    @DeleteMapping("/{id}/basket/{product_id}")
    fun deleteBasketLine(@PathVariable id: Long, @PathVariable product_id: Long) = userService.deleteBasketLine(id, product_id)
}