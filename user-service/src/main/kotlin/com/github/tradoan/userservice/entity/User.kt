package com.github.tradoan.userservice.entity
import javax.persistence.*

@Entity
data class User(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long =-1,

        @Column(name="first_name")
        var firstName: String?,

        @Column(name="last_name")
        var lastName: String?,

        @Column(unique = true)
        var email: String,

        var password: String)