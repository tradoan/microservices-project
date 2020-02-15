package com.github.tradoan.userservice.web.dto

import com.github.tradoan.userservice.entity.Product

data class BasketDTO (
        var quantity: Int,
        var product: Product
)