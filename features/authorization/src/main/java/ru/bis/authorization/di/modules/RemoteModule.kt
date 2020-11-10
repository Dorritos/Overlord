package ru.bis.authorization.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.bis.authorization.BuildConfig
import ru.bis.authorization.data.Remote
import ru.bis.authorization.remote.ApiService
import ru.bis.authorization.remote.RemoteImpl
import ru.bis.authorization.remote.Request
import ru.bis.data.remote.NetworkHandler
import ru.bis.data.remote.ServiceFactory
import javax.inject.Singleton

@Module
class RemoteModule {
    companion object {
        const val BASE_URL = "https://identity.web-kamaz.ru"
    }

    @Provides
    @Singleton
    fun provideApiService(): ApiService = ServiceFactory.makeService(BASE_URL, BuildConfig.DEBUG)

    @Provides
    @Singleton
    fun provideNetworkHandler(context: Context): NetworkHandler {
        return NetworkHandler(context)
    }

    @Provides
    @Singleton
    fun provideRequest(networkHandler: NetworkHandler): Request {
        return Request(networkHandler)
    }

    @Provides
    fun provideRemote(request: Request, service: ApiService): Remote {
        return RemoteImpl(request, service)
    }
}