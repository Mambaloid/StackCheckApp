package ru.bimbom.stackcheckapp.ui.dashboard.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.bimbom.stackcheckapp.data.repository.CharacterRepository
import javax.inject.Inject

@HiltViewModel
class CharacterScreenViewModel @Inject constructor(
    private val characterRepository: CharacterRepository
) : ViewModel() {
    private val _state = MutableStateFlow(CharacterScreenViewState())
    val state: StateFlow<CharacterScreenViewState> = _state.asStateFlow()

    init {
        loadFirstPageCharacters()
    }

    fun loadFirstPageCharacters() {
        _state.value = CharacterScreenViewState(
            isLoading = true
        )
        viewModelScope.launch {
            try {
                delay(3000)
                val result = characterRepository.getFirstPageCharacters()
                _state.value = CharacterScreenViewState(
                    characterList = result.results,
                )
            } catch (e: Exception) {
                _state.value = CharacterScreenViewState(
                    error = "Ошибка: ${e.message}"
                )
            }

        }
    }
}