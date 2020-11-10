package ru.bis.authorization.remote

import retrofit2.Response
import ru.bis.authorization_api.type.Failure
import ru.bis.data.remote.BaseRequest
import ru.bis.data.remote.NetworkHandler

class Request(networkHandler: NetworkHandler) : BaseRequest<Failure>(networkHandler) {
    override fun <Type> Response<Type>.parseError(): Failure {
        return when (code()) {
            400 -> Failure.AuthorizationError
            404 -> Failure.ServerNotFoundError
            500 -> Failure.AccountNotFoundError
            else -> Failure.UnknownError
        }
    }

    override fun getNetworkFailure(): Failure = Failure.NetworkConnectionError
    override fun getServerError(): Failure = Failure.ServerError
}