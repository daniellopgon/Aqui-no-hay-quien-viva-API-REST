package edu.iesam.anhqv_api.features.anhqv_api.domain

interface Repository {

    suspend fun findAll():Result<List<Character>>
}