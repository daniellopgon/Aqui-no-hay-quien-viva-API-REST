package edu.iesam.anhqv_api.features.anhqv_api.presentation.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import edu.iesam.anhqv_api.features.anhqv_api.domain.ErrorApp
import edu.iesam.anhqv_api.features.anhqv_api.domain.GetAllCharactersUseCase
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class LatestNewsViewModel(
    private val getAllCharactersUseCase: GetAllCharactersUseCase
) : ViewModel() {

    data class CharacterUiState(
        val loading : Boolean = false,
        val error : ErrorApp? = null,
        val done : List<Character>? = null
    )
    private val _uiState = MutableLiveData<CharacterUiState>()
    val uiState: LiveData<CharacterUiState> = _uiState

    fun loadCharacters() {
        viewModelScope.launch {
            val characters = getAllCharactersUseCase.invoke()
            _uiState.value = CharacterUiState(loading = true)
        }
    }
}
