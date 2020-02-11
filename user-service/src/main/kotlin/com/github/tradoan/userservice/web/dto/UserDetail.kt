package com.github.tradoan.userservice.web.dto

data class UserDetail(
        var id: Long ?=-1,

        var firstName: String?,

        var lastName: String?
) {
    class Builder {
        private var id: Long ?=-1
        private var firstName: String?=""
        private var lastName: String?=""

        fun id(id: Long) = apply { this.id = id }
        fun firstName(firstName: String?) = apply { this.firstName = firstName }
        fun lastName(lastName: String?) = apply { this.lastName = lastName }

        fun build() = UserDetail(
                id,
                firstName,
                lastName
        )
    }
}