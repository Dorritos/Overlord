package ru.bis.authorization.data

import ru.bis.entities.Either
import ru.bis.entities.None
import ru.bis.authorization_api.interfaces.Repository
import ru.bis.authorization_api.models.Profile
import ru.bis.authorization_api.type.Failure
import ru.bis.entities.*
import javax.inject.Inject

internal class RepositoryImpl @Inject constructor(private val cache: Cache, private val remote: Remote) : Repository {
    override fun containsAccount(): Either<Failure, Boolean> = cache.containsAccount()

    override fun login(email: String, password: String): Either<Failure, Profile> {
        return remote.login(email, password).doNext{
            cache.saveId(it)
        }.flatMap {
            remote.profile(it)
        }.doNext {
            cache.saveProfileInfo(it)
        }
    }

    override fun logout(): Either<Failure, None> {
        return cache.clearProfileInfo()
    }

    override fun getProfile(): Either<Failure, Profile> {
        return cache.getProfileInfo()
    }

    override fun updateProfile(): Either<Failure, Profile> {
        return cache.getId().flatMap {
            remote.profile(it).doNext { profile ->
                cache.saveProfileInfo(profile)
            }
        }
    }
}