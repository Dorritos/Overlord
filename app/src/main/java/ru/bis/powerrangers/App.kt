package ru.bis.powerrangers

import android.app.Application
import android.content.Context
import ru.bis.powerrangers.di.components.AppComponent
import ru.bis.powerrangers.di.components.DaggerAppComponent
import ru.bis.authorization.di.components.AuthorizationComponent
import ru.bis.authorization.di.provides.AuthorizationProvider

class App : Application(), AuthorizationProvider {
    companion object {
        lateinit var appComponent: AppComponent
        lateinit var appContext: Context
        private var authorizationComponent: AuthorizationComponent? = null
    }

    override fun onCreate() {
        super.onCreate()

        appContext = applicationContext
        initAppComponent()
    }

    private fun initAppComponent() {
        appComponent = DaggerAppComponent.create()
    }

    override fun provideAuthorization(): AuthorizationComponent {
        if (authorizationComponent == null)
            authorizationComponent = appComponent.createExample1Component().create()
        return authorizationComponent!!
    }
}