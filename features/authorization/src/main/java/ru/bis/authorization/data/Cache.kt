package ru.bis.authorization.data

import ru.bis.authorization_api.models.Profile
import ru.bis.authorization_api.type.Failure
import ru.bis.entities.Either
import ru.bis.entities.None

interface Cache {
    fun getId(): Either<Failure, String>
    fun saveId(id: String): Either<Failure, None>
    fun containsAccount(): Either<Failure, Boolean>
    fun clearProfileInfo(): Either<Failure, None>
    fun getProfileInfo(): Either<Failure, Profile>
    fun saveProfileInfo(profile: Profile): Either<Failure, None>
}