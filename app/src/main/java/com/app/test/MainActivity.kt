package com.app.test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.app.test.src.ui.navigation.DrawerMenu
import com.app.test.src.ui.navigation.MainNavigator
import com.app.test.src.ui.screens.userList.UserListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            //MainNavigator()
            DrawerMenu()
        }

    }
}

