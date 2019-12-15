package com.dongho.dev.domin.user

import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Int> {

    override fun findAll(): MutableList<User>

}