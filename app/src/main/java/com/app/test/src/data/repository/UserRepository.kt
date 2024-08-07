package com.app.test.src.data.repository

import android.util.Log
import com.app.test.src.data.model.User


class UserRepository : IUserRepository {

    override fun createUser() {
        Log.d("UserRepository", "createUser")
    }

    override fun getUsers(): List<User> {
        val users = listOf(
            User(1, "Felipe Rubio", "rubioneira@gmail.com", 1995),
            User(2, "Juan Perez", "juan.perez@gmail.com", 1990),
        )
        return users
    }

    override fun deleteUser(userId: Int) {
        Log.d("UserRepository", "deleteUser")
    }

    override fun updateUser(user: User) {
        Log.d("UserRepository", "updateUser")
    }
}