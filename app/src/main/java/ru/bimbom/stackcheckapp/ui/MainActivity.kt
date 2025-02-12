package ru.bimbom.stackcheckapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dagger.hilt.android.AndroidEntryPoint
import ru.bimbom.stackcheckapp.ui.dashboard.DashboardScreen
import ru.bimbom.stackcheckapp.ui.theme.StackCheckAppTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //TODO разобраться
        enableEdgeToEdge()
        setContent {
            StackCheckAppTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
                DashboardScreen()
            }
        }
    }
}