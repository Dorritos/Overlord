package ru.bis.authorization_api.interactor

import ru.bis.authorization_api.interfaces.Repository
import ru.bis.authorization_api.models.Profile
import ru.bis.authorization_api.type.Failure
import ru.bis.entities.AsyncUseCase
import ru.bis.entities.Either

class Login(private val repository: Repository) : AsyncUseCase<Profile, Login.Params, Failure>() {
    override suspend fun run(params: Params): Either<Failure, Profile> = repository.login(params.email, params.password)

    data class Params(val email: String, val password: String)
}