package com.app.test.src.ui.screens.userDetail

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun UserDetailScreen(userId: Int?, name: String?) {
    Column {
        Text(text = "User Detail Screen")
        Text(text = "Id del usuario: $userId")
        Text(text = "Nombre del usuario $name")

    }
}