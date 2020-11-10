package ru.bis.authorization.di.components

import dagger.Subcomponent
import ru.bis.authorization.di.modules.DomainModule
import ru.bis.authorization.di.modules.PresentationModule
import ru.bis.authorization.presentation.interfaces.AuthorizationView
import ru.bis.authorization_api.interactor.GetProfileInfo
import ru.bis.authorization_api.interactor.Logout
import ru.bis.authorization_api.interactor.UpdateProfileInfo
import javax.inject.Singleton

@Singleton
@Subcomponent(modules = [PresentationModule::class, DomainModule::class])
interface AuthorizationComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): AuthorizationComponent
    }

    fun getLoginActivityPresenter(): AuthorizationView.Presenter
    fun getLogout(): Logout
    fun getAccountInfo(): GetProfileInfo
    fun getUpdateProfileInfo(): UpdateProfileInfo
}