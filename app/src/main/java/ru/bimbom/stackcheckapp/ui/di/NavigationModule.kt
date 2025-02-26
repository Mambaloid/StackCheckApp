package ru.bimbom.stackcheckapp.ui.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.bimbom.stackcheckapp.navigation.DefaultNavigator
import ru.bimbom.stackcheckapp.navigation.Destination
import ru.bimbom.stackcheckapp.navigation.Navigator
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NavigationModule {

    @Singleton
    @Provides
    fun providesNavigator(): Navigator = DefaultNavigator(Destination.CharactersScreen)

}