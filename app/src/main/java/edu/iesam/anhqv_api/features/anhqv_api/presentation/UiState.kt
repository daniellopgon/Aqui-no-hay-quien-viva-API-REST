package edu.iesam.anhqv_api.features.anhqv_api.presentation

import edu.iesam.anhqv_api.features.anhqv_api.domain.Character
import edu.iesam.anhqv_api.features.anhqv_api.domain.ErrorApp

data class CharacterUiState(
    val loading: Boolean = false,
    val error: ErrorApp? = null,
    val done: List<Character>? = null,
    val doneCharacter: Character? = null
)