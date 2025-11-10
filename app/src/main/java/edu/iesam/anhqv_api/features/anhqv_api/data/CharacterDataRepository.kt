package edu.iesam.anhqv_api.features.anhqv_api.data

import edu.iesam.anhqv_api.features.anhqv_api.data.remote.api.ApiRemoteDataSource
import edu.iesam.anhqv_api.features.anhqv_api.data.remote.api.toModel

class CharacterDataRepository(
    private val apiRemoteDataSource: ApiRemoteDataSource
) {

    suspend fun getCharacters(): Result<List<Character>>{
        return apiRemoteDataSource.getAllCharacters().map { response ->
            response.characters.map { it.toModel() }
        }
    }

}