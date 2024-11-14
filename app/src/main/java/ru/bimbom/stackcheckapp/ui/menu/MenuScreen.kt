package ru.bimbom.stackcheckapp.ui.menu

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.rememberNavController
import ru.bimbom.stackcheckapp.ui.dashboard.NavRoutes
import ru.bimbom.stackcheckapp.ui.theme.MenuBackColor

//TODO реально вот так делать навигацию???
@Composable
fun MenuScreen(navController: NavController? = null) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MenuBackColor)
            .clickable {
                navController?.navigate(NavRoutes.Home.route) {
                    popUpTo(NavRoutes.Home.route)
                }
            }
    ) {
        Text(
            text = "УДИ",
            modifier = Modifier.align(Alignment.Center),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CameraScreenPreview() {
    MenuScreen()
}