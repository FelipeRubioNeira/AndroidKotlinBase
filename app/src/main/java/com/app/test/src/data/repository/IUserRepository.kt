package com.app.test.src.data.repository

import com.app.test.src.data.model.User

interface IUserRepository {

    fun createUser()

    fun getUsers(): List<User>

    fun deleteUser(userId: Int)

    fun updateUser(user: User)

}