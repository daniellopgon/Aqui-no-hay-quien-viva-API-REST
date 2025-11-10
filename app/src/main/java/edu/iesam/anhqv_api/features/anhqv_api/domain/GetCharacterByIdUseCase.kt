package edu.iesam.anhqv_api.features.anhqv_api.domain

class GetCharacterByIdUseCase(private val repository: CharacterRepository) {

    suspend operator fun invoke(slug: String): Result<Character> {
        return repository.findById(slug)
    }
}