package com.app.test.src.ui.screens.userList

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.test.src.data.model.User
import com.app.test.src.domain.GetUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


// --------------------- HomeViewModel --------------------- //
@HiltViewModel
class UserListViewModel @Inject constructor(
    private val getUsersUseCase: GetUsersUseCase,
) : ViewModel() {


    // --------------------- state --------------------- //
    private val _user = MutableLiveData<List<User>>() // escritura
    val users: LiveData<List<User>> get() = _user // lectura


    // --------------------- init --------------------- //
    init {
        getUsers() // ejecutar getUsers
    }


    // --------------------- methods --------------------- //
    private fun getUsers() {
        val users = getUsersUseCase.execute()
        _user.value = users
    }

    // --------------------- public methods --------------------- //
    fun onPresCard(user: User) {
        Log.d("viewModel", "onPress on card $user")
    }


}