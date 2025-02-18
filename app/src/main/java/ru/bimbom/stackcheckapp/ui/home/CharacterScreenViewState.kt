package ru.bimbom.stackcheckapp.ui.home

import ru.bimbom.stackcheckapp.data.models.Character

data class CharacterScreenViewState(
    val characterList: List<Character>? = null,
    val error: String? = null,
    val isLoading: Boolean = false
)