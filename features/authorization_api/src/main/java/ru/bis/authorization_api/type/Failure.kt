package ru.bis.authorization_api.type

sealed class Failure {
    object NetworkConnectionError : Failure()
    object ServerError : Failure()
    object ServerNotFoundError : Failure()
    object AuthorizationError : Failure()
    object AccountNotFoundError : Failure()
    object UnknownError : Failure()
}