package com.app.test.src.domain

import com.app.test.src.data.model.User
import com.app.test.src.data.repository.IUserRepository

class GetUsersUseCase(
    private val userRepository: IUserRepository
) {

    fun execute(): List<User> {
        val users = userRepository.getUsers()
        return users
    }
}