package com.app.test.src.ui.screens.userList


import android.util.Log
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.app.test.src.ui.components.userCard.UserCard
import com.app.test.src.ui.navigation.ScreensApp

@Composable
fun UserListScreen(navigation: NavHostController) {

    // --------------------- viewModel --------------------- //
    val userListViewModel: UserListViewModel = hiltViewModel()
    val users = userListViewModel.users.observeAsState(emptyList())


    // --------------------- UI --------------------- //
    LazyColumn(modifier = Modifier.padding(16.dp)) {

        items(users.value) { user ->
            UserCard(user = user, onClick = {
                Log.d("UserListScreen", "user: $user")
                navigation.navigate(
                    ScreensApp.userDetailRoute(
                        user.userId,
                        user.name
                    )
                )
            })
            Spacer(modifier = Modifier.height(8.dp))
        }
    }

}