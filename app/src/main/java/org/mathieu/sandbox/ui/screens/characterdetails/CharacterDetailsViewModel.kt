package org.mathieu.sandbox.ui.screens.characterdetails

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import org.mathieu.sandbox.data.CharacterRepositoryImpl
import org.mathieu.sandbox.domain.models.Episode

sealed interface CharacterDetailsEvent{
    data class NavigateToDetails(val id: Int) : CharacterDetailsEvent
}
class CharacterDetailsViewModel(application: Application) : AndroidViewModel(application) {
    private val _state: MutableStateFlow<CharacterDetailsState> = MutableStateFlow(CharacterDetailsState())

    val state: StateFlow<CharacterDetailsState>
        get() = _state

    private val _events = Channel<CharacterDetailsEvent>(Channel.BUFFERED)
    val events: Flow<CharacterDetailsEvent>
        get() = _events.receiveAsFlow()

    fun initialize(id: Int) {
        val character = CharacterRepositoryImpl.getCharacterByIdOrNull(id)!!

        _state.value = CharacterDetailsState(
            firstName = character.firstName,
            lastName = character.lastName,
            episodes = character.episodes
        )

    }

    fun navigateToDetails(id: Int){
        viewModelScope.launch{
            _events.send(CharacterDetailsEvent.NavigateToDetails(id = id))
        }
    }
}



data class CharacterDetailsState(
    val firstName: String = "",
    val lastName: String = "",
    val episodes: List<Episode> = listOf()
)