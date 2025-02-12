package ru.bimbom.stackcheckapp.data.api

import retrofit2.http.GET
import ru.bimbom.stackcheckapp.data.models.RickAndMortyResponse

interface RickAndMortyApi {

    @GET("/api/character")
    suspend fun getAllCharacters() : RickAndMortyResponse
}