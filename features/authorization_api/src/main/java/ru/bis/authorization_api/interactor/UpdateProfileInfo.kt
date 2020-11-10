package ru.bis.authorization_api.interactor

import ru.bis.authorization_api.interfaces.Repository
import ru.bis.authorization_api.models.Profile
import ru.bis.authorization_api.type.Failure
import ru.bis.entities.AsyncUseCase
import ru.bis.entities.Either
import ru.bis.entities.None

class UpdateProfileInfo(private val repository: Repository) : AsyncUseCase<Profile, None, Failure>() {
    override suspend fun run(params: None): Either<Failure, Profile> = repository.updateProfile()
}