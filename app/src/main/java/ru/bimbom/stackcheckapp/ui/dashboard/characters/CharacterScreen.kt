package ru.bimbom.stackcheckapp.ui.dashboard.characters

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Download

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ru.bimbom.stackcheckapp.ui.theme.CharactersBackColor

import ru.bimbom.stackcheckapp.ui.theme.Pink80

@Composable
fun CharacterScreen() {
    val viewModel = hiltViewModel<CharacterScreenViewModel>()
    val state by viewModel.state.collectAsState()
    state.error?.let {
        Toast.makeText(LocalContext.current, it, Toast.LENGTH_SHORT).show()
    }
    CharacterContent(viewModel, state)
}

@Composable
fun CharacterContent(
    viewModel: CharacterScreenViewModel,
    state: CharacterScreenViewState
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(CharactersBackColor)
    ) {
        if (state.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
            return@Box
        }

        state.characterList?.let { characterList ->
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(12.dp),
                verticalArrangement = Arrangement.spacedBy(6.dp),
            ) {
                items(characterList) { character ->
                    SimpleItemView(character.name)
                }
            }
        }

        FloatingActionButton(
            modifier = Modifier.align(Alignment.BottomEnd).padding(6.dp),
            onClick = { viewModel.loadFirstPageCharacters() },
        ) {
            Icon(Icons.Filled.Download, "Download Content")
        }


    }
}

@Composable
fun SimpleItemView(
    text: String
) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(Pink80),
        text = text
    )
}

@Preview(showBackground = true)
@Composable
fun CharacterScreenPreview() {
    CharacterScreen()
}