package ru.bis.powerrangers.interfaces

import androidx.lifecycle.LifecycleObserver
import ru.bis.authorization_api.models.Profile
import ru.bis.authorization_api.type.Failure

interface SettingsFragmentInterface {
    interface View {
        fun init(profile: Profile?)
        fun setListeners()
        fun openUserPhotoFullSize()
        fun showSyncProgressBar(isShow: Boolean)
        fun showToast(message: String)
        fun openLoginActivity()
        fun showError(failure: Failure)
    }

    interface Presenter : LifecycleObserver {
        fun init()
        fun setView(view: View)
        fun onIvUserPhotoClicked()
        fun onSyncBtnClicked()
        fun onLogoutBtnClicked()
    }
}