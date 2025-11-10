package edu.iesam.anhqv_api.features.anhqv_api.presentation.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import edu.iesam.anhqv_api.features.anhqv_api.domain.ErrorApp
import edu.iesam.anhqv_api.features.anhqv_api.domain.GetAllCharactersUseCase
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import edu.iesam.anhqv_api.features.anhqv_api.domain.Character
import edu.iesam.anhqv_api.features.anhqv_api.presentation.CharacterUiState

class ListViewModel(
    private val getAllCharactersUseCase: GetAllCharactersUseCase
) : ViewModel() {

    private val _uiState = MutableLiveData<CharacterUiState>()
    val uiState: LiveData<CharacterUiState> = _uiState

    fun loadCharacters() {
        viewModelScope.launch {
            _uiState.value = CharacterUiState(loading = true)
            getAllCharactersUseCase().fold(
                { onSuccess(it) },
                { onError(it as ErrorApp) }
            )
        }
    }

    private fun onSuccess(characters: List<Character>) {
        _uiState.value = CharacterUiState(done = characters)
    }

    private fun onError(error: ErrorApp) {
        _uiState.value = CharacterUiState(error = error)
    }
}
