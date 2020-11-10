package ru.bis.authorization.remote

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import ru.bis.authorization.data.Remote
import ru.bis.authorization_api.models.Profile
import ru.bis.authorization_api.type.Failure
import ru.bis.entities.Either

internal class RemoteImpl(private val request: Request, private val service: ApiService) : Remote {
    override fun login(email: String, password: String): Either<Failure, String> {
        return request.make(service.login(createLoginMap(email, password))) { it }
    }

    override fun profile(id: String): Either<Failure, Profile> {
        return request.make(service.profile(id)) {
            Profile(
                it.firstName,
                it.secondName,
                it.lastName,
                it.name,
                it.fullName,
                it.birthday,
                it.factAddress,
                it.registrationAddress,
                it.passport,
                it.checkingAccount,
                it.photo,
                it.inn,
                it.kpp,
                it.ogrn,
                it.id,
                it.company,
                it.description,
                it.isLegal,
                it.createDate,
                it.modifyDate,
                it.role
            )
        }
    }

    private fun createLoginMap(email: String, password: String): HashMap<String, String> {
        val map = HashMap<String, String>()
        map.apply {
            put(ApiService.PARAM_EMAIL, email)
            put(ApiService.PARAM_PASSWORD, password)
        }
        return map
    }
}