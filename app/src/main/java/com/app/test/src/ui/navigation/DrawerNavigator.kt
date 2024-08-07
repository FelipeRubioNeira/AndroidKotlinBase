package com.app.test.src.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.test.src.ui.components.topAppBar.TopAppBarComponent
import com.app.test.src.ui.screens.home.HomeScreen
import kotlinx.coroutines.launch


@Composable
fun DrawerMenu() {

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val navController = rememberNavController()

    ModalNavigationDrawer(drawerState = drawerState, drawerContent = {
        ModalDrawerSheet {


            // --------------------- title --------------------- //
            Text("Mi app", modifier = Modifier.padding(16.dp), fontSize = 20.sp)


            // --------------------- screens --------------------- //
            NavigationDrawerItem(label = { Text(text = "Home") }, selected = false, onClick = {
                navController.navigate(ScreensApp.HOME)
                scope.launch { drawerState.close() }
            })

            NavigationDrawerItem(label = { Text(text = "Listado Usuarios") },
                selected = false,
                onClick = {
                    navController.navigate(NavigatorsApp.STACK_NAVIGATOR)
                    scope.launch { drawerState.close() }
                })

        }
    }) {
        Scaffold(topBar = {
            TopAppBarComponent(onClick = {
                scope.launch { drawerState.open() }
            })
        }) { innerPadding ->

            // Screen content
            NavHost(
                navController = navController,
                startDestination = ScreensApp.HOME,
                modifier = Modifier.padding(innerPadding)
            ) {
                composable(route = ScreensApp.HOME) { HomeScreen() }
                composable(route = NavigatorsApp.STACK_NAVIGATOR) { StackNavigator() }
            }
        }
    }
}

