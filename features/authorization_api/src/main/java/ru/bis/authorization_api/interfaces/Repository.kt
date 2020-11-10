package ru.bis.authorization_api.interfaces

import ru.bis.authorization_api.models.Profile
import ru.bis.authorization_api.type.Failure
import ru.bis.entities.Either
import ru.bis.entities.None

interface Repository {
    fun containsAccount(): Either<Failure, Boolean>
    fun login(email: String, password: String): Either<Failure, Profile>
    fun logout(): Either<Failure, None>
    fun getProfile(): Either<Failure, Profile>
    fun updateProfile(): Either<Failure, Profile>
}