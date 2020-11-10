package ru.bis.powerrangers.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.bis.powerrangers.App

@Module
class PresentationModule(private val context: Context) {

    @Provides
    fun provideSettingFragmentPresenter(): SettingsFragmentInterface.Presenter {
        val authorizationComponent = (context as App).provideAuthorizationComponent()
        return SettingsFragmentPresenter(authorizationComponent.getLogout(), authorizationComponent.getAccountInfo(), authorizationComponent.getUpdateProfileInfo())
    }
}