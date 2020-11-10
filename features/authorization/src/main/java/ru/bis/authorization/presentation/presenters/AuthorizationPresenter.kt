package ru.bis.authorization.presentation.presenters

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import ru.bis.authorization.presentation.interfaces.AuthorizationView
import ru.bis.authorization.presentation.presenters.AuthorizationPresenter.Companion.EMAIL_VALIDATOR_EXPRESSION
import ru.bis.authorization_api.interactor.CheckAccount
import ru.bis.authorization_api.interactor.Login
import ru.bis.authorization_api.models.Profile
import ru.bis.authorization_api.type.Failure
import ru.bis.entities.Either
import ru.bis.entities.None
import java.util.regex.Pattern

internal class AuthorizationPresenter(private val checkAccount: CheckAccount, private val login: Login ) : AuthorizationView {

    companion object {
        const val EMAIL_VALIDATOR_EXPRESSION = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$"
    }

    private lateinit var view: AuthorizationView.View

    override fun setView(view: AuthorizationView.View) {
        this.view = view
    }

    override fun init() {
        view.init()
        view.setListeners()

        checkAccount()
    }

    private fun checkAccount() {
        checkAccount(None()) {
            if ((it as Either.Right).r)
                view.openContentActivity()
        }
    }

    override fun btnLoginClicked(login: String, password: String) {
        if (login.isEmpty() || password.isEmpty()) {
            view.showFieldsIsEmpty()
            return
        }

        if (!login.validEmail()) {
            view.showEmailNotValid()
            view.hideSoftKeyboard()
            return
        }

        view.showLoadingProgressBar()
        login(Login.Params(login, password)) {
            it.either(::authorizationError, ::authorizationSuccess)
        }
    }

    private fun authorizationSuccess(profile: Profile) {
        checkAccount()
    }

    private fun authorizationError(failure: Failure) {
        view.hideLoadingProgressBar()
        view.authorizationError(failure)
    }

    private fun String.validEmail(): Boolean {
        val pattern = Pattern.compile(AuthorizationView.EMAIL_VALIDATOR_EXPRESSION, Pattern.CASE_INSENSITIVE)
        val matcher = pattern.matcher(this)
        return matcher.matches()
    }

}