package ru.bis.authorization.di.provides

import ru.bis.authorization.di.components.AuthorizationComponent

interface AuthorizationProvider {
    fun provideAuthorization(): AuthorizationComponent
}