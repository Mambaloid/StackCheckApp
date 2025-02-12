package ru.bimbom.stackcheckapp.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.bimbom.stackcheckapp.data.repository.CharacterRepository
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val characterRepository: CharacterRepository
) : ViewModel() {
    private val _state = MutableStateFlow(HomeScreenViewState())
    val state: StateFlow<HomeScreenViewState> = _state.asStateFlow()

    fun loadAllCharacters() {
        viewModelScope.launch {
            try {
                val result = characterRepository.getAllCharacters()
                val uuid = UUID.randomUUID().toString().take(5)
                _state.value = HomeScreenViewState(
                    toast = "Удача! Загружено ${result.info.count} персонажа. $uuid"
                )
            } catch (e: Exception) {
                _state.value = HomeScreenViewState(
                    toast = "Ошибка"
                )
            }

        }
    }
}