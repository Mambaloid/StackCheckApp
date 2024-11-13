package ru.bimbom.stackcheckapp.ui.camera

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ru.bimbom.stackcheckapp.ui.theme.CameraBackColor

@Composable
fun CameraScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(CameraBackColor),
    ) {
        Text(
            text = "тут будет ваша камера!",
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CameraScreenPreview() {
    CameraScreen()
}