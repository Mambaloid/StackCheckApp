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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import ru.bimbom.stackcheckapp.navigation.Destination
import ru.bimbom.stackcheckapp.navigation.NavigationAction
import ru.bimbom.stackcheckapp.navigation.Navigator
import ru.bimbom.stackcheckapp.ui.dashboard.episode.EpisodeScreen
import ru.bimbom.stackcheckapp.ui.dashboard.characters.CharacterScreen
import ru.bimbom.stackcheckapp.ui.dashboard.location.LocationScreen
import ru.bimbom.stackcheckapp.utils.ObserveAsEvents

@Composable
fun DashboardScreen(
    viewModel: DashboardViewModel = hiltViewModel()
) {
    val navController = rememberNavController()
    val navigator = viewModel.getNavigator()

    ObserveAsEvents(flow = navigator.navigationActions) { action ->
        when(action) {
            is NavigationAction.Navigate -> navController.navigate(
                action.destination.route
            ) {
                action.navOptions(this)
            }
            NavigationAction.NavigateUp -> navController.navigateUp()
        }
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar {
                //TODO убрать ненужную обработку кнопки назад, разобраться
                val backStackEntry = navController.currentBackStackEntryAsState()
                val currentRoute = backStackEntry.value?.destination?.route



                NavBarItems.BarItems.forEach { navItem ->
                    NavigationBarItem(
                        selected = currentRoute == navItem.destination.route,
                        onClick = {
                            viewModel.navigateTo(navItem.destination) {
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
            startDestination = navigator.startDestination.route,
            modifier = Modifier.padding(padding)
        ) {
            composable(Destination.CharactersScreen.route) {
                CharacterScreen()
            }
            composable(Destination.LocationsScreen.route) {
                LocationScreen()
            }
            composable(Destination.EpisodesScreen.route) {
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
            destination = Destination.CharactersScreen
        ),
        BarItem(
            title = "Локации",
            image = Icons.Filled.Nature,
            destination = Destination.LocationsScreen
        ),
        BarItem(
            title = "Эпизоды",
            image = Icons.Filled.Movie,
            destination = Destination.EpisodesScreen
        )
    )
}

data class BarItem(
    val title: String,
    val image: ImageVector,
    val destination: Destination
)

@Preview(showBackground = true)
@Composable
fun DashboardScreenPreview() {
    DashboardScreen()
}