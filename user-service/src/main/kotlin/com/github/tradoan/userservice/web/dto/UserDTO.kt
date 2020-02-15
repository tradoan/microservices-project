package com.github.tradoan.userservice.web.dto

data class UserDTO(
        var id: Long ?=-1,

        var firstName: String?=null,

        var lastName: String?=null,

        var baskets: MutableSet<BasketDTO>?= null)