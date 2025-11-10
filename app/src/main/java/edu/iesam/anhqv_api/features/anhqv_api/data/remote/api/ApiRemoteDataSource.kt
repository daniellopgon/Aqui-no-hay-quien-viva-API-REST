package edu.iesam.anhqv_api.features.anhqv_api.data.remote.api

import edu.iesam.anhqv_api.features.anhqv_api.core.api.ApiClient
import edu.iesam.anhqv_api.features.anhqv_api.domain.ErrorApp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ApiRemoteDataSource(private val api: ApiClient) {

    suspend fun getAllCharacters(): Result<CharacterApiResponse> {
        return withContext(Dispatchers.IO) {

            val apiService = api.createService(ApiService::class.java)
            val response = apiService.getAllCharacters()

            if (response.isSuccessful && response.body() != null) {
                val characters = response.body()!!
                Result.success(characters)
            } else {
                val error = error("Error de red")
                when (error) {
                    is ErrorApp.InternetError -> Result.failure(ErrorApp.InternetError)
                    is ErrorApp.SeverError -> Result.failure(ErrorApp.SeverError)
                    else -> Result.failure(ErrorApp.UnknownError)
                }
            }
        }

    }
}