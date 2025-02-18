package ru.bimbom.stackcheckapp.data.repository

import ru.bimbom.stackcheckapp.data.models.RickAndMortyResponse

interface CharacterRepository {

    suspend fun getFirstPageCharacters(): RickAndMortyResponse

}