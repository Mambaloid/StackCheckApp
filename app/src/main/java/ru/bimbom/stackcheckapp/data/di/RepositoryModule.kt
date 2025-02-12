package ru.bimbom.stackcheckapp.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.bimbom.stackcheckapp.data.api.RickAndMortyApi
import ru.bimbom.stackcheckapp.data.repository.CharacterRepository
import ru.bimbom.stackcheckapp.data.repository.CharacterRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun provideCharacterRepository(api: RickAndMortyApi): CharacterRepository = CharacterRepositoryImpl(api)

}