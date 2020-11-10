package ru.bis.authorization_api.interactor

import ru.bis.authorization_api.interfaces.Repository
import ru.bis.authorization_api.models.Profile
import ru.bis.authorization_api.type.Failure
import ru.bis.entities.Either
import ru.bis.entities.None
import ru.bis.entities.UseCase

class GetProfileInfo(private val repository: Repository) : UseCase<Profile, None, Failure>() {
    override fun run(params: None): Either<Failure, Profile> = repository.getProfile()
}