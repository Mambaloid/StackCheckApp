package ru.bimbom.stackcheckapp.ui.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavOptionsBuilder
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.bimbom.stackcheckapp.navigation.Destination
import ru.bimbom.stackcheckapp.navigation.Navigator
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val navigator: Navigator
): ViewModel() {

    fun getNavigator() = navigator

    fun navigateTo(destination: Destination, builder: NavOptionsBuilder.() -> Unit) {
        viewModelScope.launch {
            navigator.navigate(destination, builder)
        }
    }

}