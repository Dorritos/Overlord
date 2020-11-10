package ru.bis.authorization.di.modules

import dagger.Module
import dagger.Provides
import ru.bis.authorization.presentation.interfaces.AuthorizationView
import ru.bis.authorization.presentation.presenters.AuthorizationPresenter

@Module
class PresentationModule {

    @Provides
    fun provideAuthorizationPresenter(): AuthorizationView.Presenter {
        return AuthorizationPresenter()
    }
}