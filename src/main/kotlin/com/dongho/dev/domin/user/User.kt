package com.dongho.dev.domin.user

import javax.persistence.*

@Entity
data class User(
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,

    var name: String,
    var age: Int)