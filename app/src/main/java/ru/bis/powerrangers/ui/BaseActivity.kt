package ru.bis.powerrangers.ui

import androidx.appcompat.app.AppCompatActivity
import ru.bis.authorization_api.type.Failure
import ru.bis.powerrangers.R
import ru.bis.powerrangers.helpers.showToast

abstract class BaseActivity : AppCompatActivity() {
    fun showError(failure: Failure) {
        when (failure) {
            is Failure.UnknownError -> showToast(getString(R.string.failure_unknown_error))
            is Failure.AuthorizationError -> showToast(getString(R.string.failure_authorization_error))
            is Failure.AccountNotFoundError -> showToast(getString(R.string.failure_account_not_found_error))
            is Failure.ServerNotFoundError -> showToast(getString(R.string.failure_server_not_found_error))
            is Failure.ServerError -> showToast(getString(R.string.failure_server_error))
            is Failure.NetworkConnectionError -> showToast(getString(R.string.failure_network_connection_error))
        }
    }
}