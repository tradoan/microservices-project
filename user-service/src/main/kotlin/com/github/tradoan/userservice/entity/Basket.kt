package com.github.tradoan.userservice.entity

data class Basket (
        var quantity: Int,
        var product: Product,
        var totalPrice: Double
)