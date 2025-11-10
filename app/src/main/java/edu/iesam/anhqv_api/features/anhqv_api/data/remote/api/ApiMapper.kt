package edu.iesam.anhqv_api.features.anhqv_api.data.remote.api

import edu.iesam.anhqv_api.features.anhqv_api.domain.Character


fun CharacterApiModel.toModel(): Character {
    return Character(
        this.id,
        this.name,
        this.surname,
        this.secondSurname,
        this.shortname,
        this.imageUrl
    )
}