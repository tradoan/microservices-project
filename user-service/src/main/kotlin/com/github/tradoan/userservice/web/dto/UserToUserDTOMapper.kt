package com.github.tradoan.userservice.web.dto

import com.github.tradoan.userservice.entity.User
import org.springframework.stereotype.Component
import java.util.function.Function

@Component
class UserToUserDTOMapper: Function<User, UserDTO>{

    override fun apply(p0: User): UserDTO {
        val userDTO = UserDTO()

        userDTO.id = p0.id
        userDTO.firstName = p0.firstName
        userDTO.lastName = p0.lastName

        return userDTO
    }
}