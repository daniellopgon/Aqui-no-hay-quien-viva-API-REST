package edu.iesam.anhqv_api.features.anhqv_api.presentation.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.iesam.anhqv_api.features.anhqv_api.domain.ErrorApp
import edu.iesam.anhqv_api.features.anhqv_api.domain.GetCharacterByIdUseCase
import edu.iesam.anhqv_api.features.anhqv_api.presentation.CharacterUiState
import kotlinx.coroutines.launch
import edu.iesam.anhqv_api.features.anhqv_api.domain.Character


class DetailViewModel(
    private val getCharacterByIdUseCase: GetCharacterByIdUseCase
) : ViewModel() {

    private val _uiState = MutableLiveData<CharacterUiState>()
    val uiState: LiveData<CharacterUiState> = _uiState

    fun loadCharacter(slug:String) {
        viewModelScope.launch {
            _uiState.value = CharacterUiState(loading = true)
            getCharacterByIdUseCase(slug).fold(
                {onSucces(it)},
                {onError(it as ErrorApp)}
            )
        }
    }

    private fun onSucces(character:Character){
        _uiState.value = CharacterUiState(doneCharacter = character)
    }

    private fun onError(error: ErrorApp){
        _uiState.value = CharacterUiState(error = error)
    }
}