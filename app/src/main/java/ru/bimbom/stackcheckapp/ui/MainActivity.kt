package ru.bimbom.stackcheckapp.ui

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import dagger.hilt.android.AndroidEntryPoint
import ru.bimbom.stackcheckapp.navigation.Navigator
import ru.bimbom.stackcheckapp.ui.dashboard.DashboardScreen
import ru.bimbom.stackcheckapp.ui.theme.StackCheckAppTheme
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    // Declare the launcher at the top of your Activity/Fragment:
    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission(),
    ) { isGranted: Boolean ->
        if (isGranted) {
            // FCM SDK (and your app) can post notifications.
        } else {
            // TODO: Inform user that that your app will not show notifications.
        }
    }

    private fun checkAndRequestNotificationPermission() {
        // Проверяем, требуется ли запрашивать разрешение (только для Android 13 и выше)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            when {
                // Разрешение уже предоставлено
                ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.POST_NOTIFICATIONS
                ) == PackageManager.PERMISSION_GRANTED -> {
//                    showNotification()
                }
                // Нужно показать объяснение, почему нужно разрешение
                shouldShowRequestPermissionRationale(Manifest.permission.POST_NOTIFICATIONS) -> {
//                    showExplanationDialog()
                }
                // Запрашиваем разрешение
                else -> {
                    requestPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
                }
            }
        } else {
            // Для версий ниже Android 13 разрешение не требуется
//            showNotification()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        checkAndRequestNotificationPermission()
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