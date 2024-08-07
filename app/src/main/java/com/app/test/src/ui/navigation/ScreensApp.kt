package com.app.test.src.ui.navigation

object ScreensApp {

    // routes
    const val USER_LIST = "userList"
    const val USER_DETAIL = "userDetail/{userId}/{name}"

    // functions
    fun userDetailRoute(userId: Int, name: String) = "userDetail/$userId/$name"
}