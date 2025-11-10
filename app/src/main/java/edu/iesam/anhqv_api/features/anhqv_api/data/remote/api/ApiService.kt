package edu.iesam.anhqv_api.features.anhqv_api.data.remote.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("characters")
    suspend fun getAllCharacters(): Response<CharacterApiResponse>

    @GET("/characters/{slug}")
    suspend fun getCharacterById(@Path("slug") slug: String): Response<CharacterApiModel>

}