package edu.iesam.anhqv_api.features.anhqv_api.core.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    private val BASE_URL = "http://api.anhqv-stats.es/api/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun <T> createService(typeClass: Class<T>): T {
        return retrofit.create(typeClass)
    }
}