package ru.bis.powerrangers.di.components

import dagger.Component
import ru.bis.authorization.di.components.AuthorizationComponent

@Component
interface AppComponent {
    fun createExample1Component(): AuthorizationComponent.Factory
}