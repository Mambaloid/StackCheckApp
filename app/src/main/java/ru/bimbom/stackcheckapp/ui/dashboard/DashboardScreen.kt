package ru.bimbom.stackcheckapp.ui.dashboard

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Group
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material.icons.filled.Nature
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import ru.bimbom.stackcheckapp.ui.dashboard.episode.EpisodeScreen
import ru.bimbom.stackcheckapp.ui.dashboard.characters.CharacterScreen
import ru.bimbom.stackcheckapp.ui.dashboard.location.LocationScreen

@Composable
fun DashboardScreen() {
    val navController = rememberNavController()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar {
                //TODO убрать ненужную обработку кнопки назад, разобраться
                val backStackEntry = navController.currentBackStackEntryAsState()
                val currentRoute = backStackEntry.value?.destination?.route

                NavBarItems.BarItems.forEach { navItem ->
                    NavigationBarItem(
                        selected = currentRoute == navItem.route,
                        onClick = {
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
                                imageVector = navItem.image,
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
            startDestination = NavRoutes.Character.route,
            modifier = Modifier.padding(padding)
        ) {
            composable(NavRoutes.Character.route) {
                CharacterScreen()
            }
            composable(NavRoutes.Location.route) {
                LocationScreen()
            }
            composable(NavRoutes.Episode.route) {
                EpisodeScreen()
            }
        }
    }
}

object NavBarItems {
    val BarItems = listOf(
        BarItem(
            title = "Персонажи",
            image = Icons.Filled.Group,
            route = NavRoutes.Character.route
        ),
        BarItem(
            title = "Локации",
            image = Icons.Filled.Nature,
            route = NavRoutes.Location.route
        ),
        BarItem(
            title = "Эпизоды",
            image = Icons.Filled.Movie,
            route = NavRoutes.Episode.route
        )
    )
}

data class BarItem(
    val title: String,
    val image: ImageVector,
    val route: String
)

sealed class NavRoutes(val route: String) {
    object Character : NavRoutes("character")
    object Location : NavRoutes("location")
    object Episode : NavRoutes("episode")
}

@Preview(showBackground = true)
@Composable
fun DashboardScreenPreview() {
    DashboardScreen()
}