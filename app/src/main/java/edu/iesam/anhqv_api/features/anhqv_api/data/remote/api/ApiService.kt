package edu.iesam.anhqv_api.features.anhqv_api.data.remote.api

import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("characters")
    suspend fun getAllCharacters(): Response<CharacterApiResponse>

}