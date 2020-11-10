package ru.bis.authorization.presentation.interfaces

import androidx.lifecycle.LifecycleObserver
import ru.bis.authorization_api.type.Failure
import ru.bis.entities.None

interface AuthorizationView {
    interface View {
        fun init()
        fun setListeners()
        fun openContentActivity()
        fun showFieldsIsEmpty()
        fun showEmailNotValid()
        fun hideSoftKeyboard()
        fun authorizationError(failure: Failure)
        fun showLoadingProgressBar()
        fun hideLoadingProgressBar()
    }

    interface Presenter : LifecycleObserver {
        fun setView(view: View)
        fun init()
        fun btnLoginClicked(login: String, password: String)
    }
}