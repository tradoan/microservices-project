package com.github.tradoan.userservice.sevice

import com.github.tradoan.userservice.client.BasketClient
import com.github.tradoan.userservice.entity.Basket
import com.github.tradoan.userservice.entity.User
import com.github.tradoan.userservice.web.dto.UserDTO
import com.github.tradoan.userservice.web.dto.UserToUserDTOMapper
import com.github.tradoan.userservice.repository.UserRepository
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand
import org.springframework.stereotype.Service


@Service
class UserService(private val userRepository: UserRepository,
                  private val basketClient: BasketClient,
                  private val userToUserDTOMapper: UserToUserDTOMapper) {

    fun getAllUser(): MutableSet<UserDTO> {
        var users: MutableIterable<User> = userRepository.findAll()

        var userDTOs:MutableSet<UserDTO> = mutableSetOf()

        for(user: User in users) {

            var userDTO: UserDTO = userToUserDTOMapper.apply(user)

            userDTOs.add(userDTO)
        }
        return userDTOs
    }

    @HystrixCommand(fallbackMethod = "notFoundProducts")
    fun getItemsForUser(id: Long): UserDTO {
        var user: User =  userRepository.findById(id).get()

        var userDTO: UserDTO = userToUserDTOMapper.apply(user)

        var products: MutableSet<Basket>? = basketClient.getProductsOfUser(id)

        userDTO.baskets = products

        return userDTO

    }
/*
    fun getUserById(id: Long): UserDetail? {
        var user: User = userRepository.findById(id).orElse(null)

        return if (user == null) {
            null
        } else {
            UserDetail.Builder()
                    .id(user.id)
                    .firstName(user.firstName)
                    .lastName(user.lastName)
                    .build();
        }
        }
 */
    fun getUserById(id: Long): UserDTO {
        return userToUserDTOMapper.apply(userRepository.findById(id).get())
}

    fun createNewUser(user: User) = userRepository.save(user)

    fun editUser(user: User, id: Long) {
        user.id = id
        userRepository.save(user)
    }

    fun deleteUser(id: Long) = userRepository.deleteById(id)

    fun login(user: User): UserDTO {
        return when {
            !userRepository.existsByEmail(user.email)-> {
                 throw Exception("Wrong Email")

            }
            user.password != userRepository.findPasswordByEmail(user.email) -> {
                 throw Exception("Wrong Password")

            }
            else -> {
                userToUserDTOMapper.apply(userRepository.findByEmail(user.email))

            }
        }
    }

    fun notFoundProducts(id: Long) : UserDTO = UserDTO()
}
