package ru.bis.powerrangers.ui

import android.app.PendingIntent
import android.content.Context
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import kotlinx.android.synthetic.main.authorization_fragment.*
import ru.bis.authorization.di.provides.AuthorizationComponentProvider
import ru.bis.powerrangers.App
import ru.bis.powerrangers.R
import ru.bis.authorization.presentation.interfaces.AuthorizationView
import ru.bis.authorization_api.type.Failure
import ru.bis.powerrangers.helpers.showToast

class LoginActivity : BaseActivity(), AuthorizationView {

private lateinit var presenter: AuthorizationView.Presenter
private lateinit var mPendingIntent: PendingIntent

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.authorization_fragment)

    App.appComponent.inject(this)

    presenter = (applicationContext as AuthorizationComponentProvider)
        .provideAuthorizationComponent().getLoginActivityPresenter()

    lifecycle.addObserver(presenter)

    presenter.setView(this)
    presenter.init()
}

override fun onResume() {
    super.onResume()
    mAdapter.enableForegroundDispatch(this, mPendingIntent, null, null)
}

override fun onPause() {
    super.onPause()
    mAdapter.disableForegroundDispatch(this)
}

override fun init() {
 //TODO ты ебанутый
}

override fun setListeners() {
    btn_login.setOnClickListener { presenter.btnLoginClicked(et_email.text.toString(), et_password.text.toString()) }
}

override fun openContentActivity() {
    navigator.showHome(this)
    finish()
}

override fun showFieldsIsEmpty() {
    showToast(getString(R.string.empty_fields))
}

override fun showEmailNotValid() {
    showToast(getString(R.string.invalid_email))
}

override fun hideSoftKeyboard() {
    currentFocus?.let {
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(it.windowToken, 0)
    }
}

override fun authorizationError(failure: Failure) {
    showError(failure)
}

override fun showLoadingProgressBar() {
    clProgressBar.visibility = View.VISIBLE
    clMainLayout.visibility = View.INVISIBLE
    (ivProgressBar.drawable as AnimationDrawable).start()
}

override fun hideLoadingProgressBar() {
    clProgressBar.visibility = View.GONE
    clMainLayout.visibility = View.VISIBLE
    (ivProgressBar.drawable as AnimationDrawable).stop()
}

}