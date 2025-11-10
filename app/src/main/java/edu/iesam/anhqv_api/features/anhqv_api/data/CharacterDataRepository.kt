package edu.iesam.anhqv_api.features.anhqv_api.data

import edu.iesam.anhqv_api.features.anhqv_api.data.remote.api.ApiRemoteDataSource
import edu.iesam.anhqv_api.features.anhqv_api.data.remote.api.toModel
import edu.iesam.anhqv_api.features.anhqv_api.domain.CharacterRepository
import edu.iesam.anhqv_api.features.anhqv_api.domain.Character

class CharacterDataRepository(
    private val apiRemoteDataSource: ApiRemoteDataSource
) : CharacterRepository {

    override suspend fun findAll(): Result<List<Character>> {
        return apiRemoteDataSource.getAllCharacters().map { response ->
            response.characters.map { it.toModel() }
        }
    }

    override suspend fun findById(slug: String): Result<Character> {
        return apiRemoteDataSource.getCharacterById(slug).map { apiModel ->
            apiModel.toModel()
        }
    }
}