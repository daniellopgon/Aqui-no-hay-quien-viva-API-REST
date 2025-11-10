package edu.iesam.anhqv_api.features.anhqv_api.domain

sealed class ErrorApp : Throwable() {
    object InternetError : ErrorApp()
    object SeverError : ErrorApp()
    object UnknownError : ErrorApp()
}