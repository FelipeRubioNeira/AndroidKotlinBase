package com.app.test.src.ui.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.app.test.src.ui.screens.userDetail.UserDetailScreen
import com.app.test.src.ui.screens.userList.UserListScreen


@Composable
fun MainNavigator() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = ScreensApp.USER_LIST) {

        // --------------------- screens --------------------- //

        // UserListScreen
        composable(route = ScreensApp.USER_LIST) {
            UserListScreen(navController)
        }

        // UserDetailScreen
        composable(
            route = ScreensApp.USER_DETAIL,
            arguments = listOf(navArgument("userId") { type = NavType.IntType },
                navArgument("name") { type = NavType.StringType })
        ) {navigation->
            val userId = navigation.arguments?.getInt("userId")
            val name = navigation.arguments?.getString("name")
            UserDetailScreen(userId, name)
        }

    }

}

