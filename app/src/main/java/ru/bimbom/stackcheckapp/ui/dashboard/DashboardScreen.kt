package ru.bimbom.stackcheckapp.ui.dashboard

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import ru.bimbom.stackcheckapp.R
import ru.bimbom.stackcheckapp.ui.camera.CameraScreen
import ru.bimbom.stackcheckapp.ui.home.HomeScreen
import ru.bimbom.stackcheckapp.ui.menu.MenuScreen

@Composable
fun DashboardScreen() {
    val navController = rememberNavController()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar {
                //TODO разобраться что это такое
                val backStackEntry = navController.currentBackStackEntryAsState()
                val currentRoute = backStackEntry.value?.destination?.route

                NavBarItems.BarItems.forEach { navItem ->
                    NavigationBarItem(
                        selected = currentRoute == navItem.route,
                        onClick = {
                            //TODO изучить вот это
                            navController.navigate(navItem.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = {
                            Icon(
                                painter = painterResource(navItem.image),
                                contentDescription = navItem.title
                            )
                        },
                        label = {
                            Text(text = navItem.title)
                        }
                    )
                }
            }
        }
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = NavRoutes.Home.route,
            modifier = Modifier.padding(padding)
        ) {
            composable(NavRoutes.Home.route) {
                HomeScreen()
            }
            composable(NavRoutes.Menu.route) {
                MenuScreen(navController)
            }
            composable(NavRoutes.Cam.route) {
                CameraScreen()
            }
        }
    }
}

object NavBarItems {
    val BarItems = listOf(
        BarItem(
            title = "Главная",
            image = R.drawable.ic_home_24_filled,
            route = NavRoutes.Home.route
        ),
        BarItem(
            title = "Меню",
            image = R.drawable.ic_menu_24_filled,
            route = NavRoutes.Menu.route
        ),
        BarItem(
            title = "Камера",
            image = R.drawable.ic_videocam_24_filled,
            route = NavRoutes.Cam.route
        )
    )
}

data class BarItem(
    val title: String,
    @DrawableRes val image: Int,
    val route: String
)


sealed class NavRoutes(val route: String) {
    object Home : NavRoutes("home")
    object Menu : NavRoutes("menu")
    object Cam : NavRoutes("cam")
}


@Preview(showBackground = true)
@Composable
fun DashboardScreenPreview() {
    DashboardScreen()
}