package ru.bimbom.stackcheckapp.ui.dashboard.location

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ru.bimbom.stackcheckapp.ui.theme.LocationBackColor

@Composable
fun LocationScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(LocationBackColor)

    ) {
        Text(
            text = "УДИ",
            modifier = Modifier.align(Alignment.Center),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LocationScreenPreview() {
    LocationScreen()
}