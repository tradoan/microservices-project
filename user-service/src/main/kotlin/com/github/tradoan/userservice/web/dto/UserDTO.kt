package com.github.tradoan.userservice.web.dto

import com.github.tradoan.userservice.entity.Basket

data class UserDTO(
        var id: Long ?=-1,

        var firstName: String?=null,

        var lastName: String?=null,

        var baskets: MutableSet<Basket>?= null)