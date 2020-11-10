package ru.bis.authorization.data

import ru.bis.authorization_api.models.Profile
import ru.bis.authorization_api.type.Failure
import ru.bis.entities.Either

interface Remote {
    fun login(email: String, password: String): Either<Failure, String>
    fun profile(id: String): Either<Failure, Profile>
}