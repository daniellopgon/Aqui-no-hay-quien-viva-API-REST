package edu.iesam.anhqv_api.features.anhqv_api.domain

import com.google.gson.annotations.SerializedName

data class Character(
    val id: Int,
    val name: String,
    val surname: String,
    @SerializedName("second_surname")
    val secondSurname: String,
    val shortname: String,
    @SerializedName("image_url")
    val imageUrl: String
)