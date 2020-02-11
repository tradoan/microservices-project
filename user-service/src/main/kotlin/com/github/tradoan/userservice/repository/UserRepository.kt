package com.github.tradoan.userservice.repository

import com.github.tradoan.userservice.entity.User
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: CrudRepository<User, Long> {
    @Query("SELECT u.password FROM User u where u.email = :email")
    fun findPasswordByEmail(@Param("email") email : String): String
    fun existsByEmail(email: String): Boolean
    fun findByEmail(@Param("email") email: String): User
}