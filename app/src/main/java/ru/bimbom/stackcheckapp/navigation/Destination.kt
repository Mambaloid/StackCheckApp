package ru.bimbom.stackcheckapp.navigation

sealed interface Destination {
    val route: String

    data object DashboardScreen: Destination {
        override val route: String
            get() = "dashboard"
    }

    data object CharactersScreen: Destination {
        override val route: String
            get() = "characters"
    }

    data object LocationsScreen: Destination {
        override val route: String
            get() = "locations"
    }

    data object EpisodesScreen: Destination {
        override val route: String
            get() = "episodes"
    }
}