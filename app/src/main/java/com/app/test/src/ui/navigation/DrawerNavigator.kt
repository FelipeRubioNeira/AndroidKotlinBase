package com.app.test.src.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
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
                navController.navigate(ScreensApp2.HOME)
                scope.launch { drawerState.close() }
            })

            NavigationDrawerItem(label = { Text(text = "Settings") }, selected = false, onClick = {
                navController.navigate(ScreensApp2.SETTINGS)
                scope.launch { drawerState.close() }
            })

            NavigationDrawerItem(label = { Text(text = "Profile") }, selected = false, onClick = {
                navController.navigate(ScreensApp2.PROFILE)
                scope.launch { drawerState.close() }
            })

            NavigationDrawerItem(label = { Text(text = "Navigator") }, selected = false, onClick = {
                navController.navigate(ScreensApp2.MAIN_NAVIGATOR)
                scope.launch { drawerState.close() }
            })
            
        }
    }) {
        Scaffold(topBar = {
            TopAppBar(title = { Text("My App") }, navigationIcon = {
                IconButton(onClick = {
                    scope.launch { drawerState.open() }
                }) {
                    Icon(Icons.Default.Menu, contentDescription = "Menu")
                }
            })
        }) { innerPadding ->
            // Screen content
            NavHost(
                navController = navController,
                startDestination = ScreensApp2.HOME,
                modifier = Modifier.padding(innerPadding)
            ) {
                composable(ScreensApp2.HOME) { HomeScreen() }
                composable(ScreensApp2.SETTINGS) { SettingsScreen() }
                composable(ScreensApp2.PROFILE) { ProfileScreen() }
                composable(ScreensApp2.MAIN_NAVIGATOR) { MainNavigator() }
            }
        }
    }
}

object ScreensApp2 {
    const val HOME = "home"
    const val SETTINGS = "settings"
    const val PROFILE = "profile"
    const val MAIN_NAVIGATOR = "mainNavigator"
}

@Composable
fun HomeScreen() {
    Text("Home Screen", modifier = Modifier.padding(16.dp))
}

@Composable
fun SettingsScreen() {
    Text("Settings Screen", modifier = Modifier.padding(16.dp))
}

@Composable
fun ProfileScreen() {
    Text("Profile Screen", modifier = Modifier.padding(16.dp))
}