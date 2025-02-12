package ru.bimbom.stackcheckapp.ui.home

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel

import ru.bimbom.stackcheckapp.ui.theme.HomeBackColor

@Composable
fun HomeScreen() {
    val viewModel = hiltViewModel<HomeScreenViewModel>()
    val state by viewModel.state.collectAsState()
    HomeContent(viewModel, state)
}

@Composable
fun HomeContent(
    viewModel: HomeScreenViewModel,
    state: HomeScreenViewState
) {
    state.toast?.let {
        Toast.makeText(LocalContext.current, "УЕ $it", Toast.LENGTH_SHORT).show()
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(HomeBackColor)
            .clickable {
                viewModel.loadAllCharacters()
            }
    ) {
        Text(
            text = "вы дома!",
            modifier = Modifier.align(Alignment.Center)
        )
        CircularProgressIndicator(
            modifier = Modifier.align(Alignment.Center)
        )

    }
}

@Preview(showBackground = true)
@Composable
fun CameraScreenPreview() {
    HomeScreen()
}