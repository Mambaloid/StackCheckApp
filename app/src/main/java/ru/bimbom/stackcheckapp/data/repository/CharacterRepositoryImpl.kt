package ru.bimbom.stackcheckapp.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.bimbom.stackcheckapp.data.api.RickAndMortyApi
import ru.bimbom.stackcheckapp.data.models.RickAndMortyResponse
import javax.inject.Singleton

@Singleton
class CharacterRepositoryImpl(
    private val rickAndMortyApi: RickAndMortyApi
) : CharacterRepository {

    override suspend fun getFirstPageCharacters(): RickAndMortyResponse = withContext(Dispatchers.IO) {
        rickAndMortyApi.getAllCharacters()
    }


}