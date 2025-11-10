package edu.iesam.anhqv_api.features.anhqv_api.domain

class GetAllCharactersUseCase(private val repository: Repository) {

    suspend operator fun invoke(): Result<List<Character>> {
        return repository.findAll()
    }
}
