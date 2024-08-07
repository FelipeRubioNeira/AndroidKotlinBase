package com.app.test.src.ui.navigation

object NavigatorsApp {

    const val STACK_NAVIGATOR = "stackNavigator"

}

object ScreensApp {

    // routes
    const val HOME = "home"
    const val USER_LIST = "userList"
    const val USER_DETAIL = "userDetail/{userId}/{name}"

    // functions
    fun userDetailRoute(userId: Int, name: String) = "userDetail/$userId/$name"
}