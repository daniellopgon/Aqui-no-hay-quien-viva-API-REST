package edu.iesam.anhqv_api.features.anhqv_api.domain

interface CharacterRepository {

    suspend fun findAll():Result<List<Character>>

    suspend fun findById(slug:String):Result<Character>
}