package ru.bis.powerrangers.ui.fragments

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Base64
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import ru.bis.authorization_api.models.Profile
import ru.bis.authorization_api.type.Failure
import ru.bis.powerrangers.R
import ru.bis.powerrangers.interfaces.SettingsFragmentInterface
import ru.bis.powerrangers.ui.BaseActivity
import javax.inject.Inject

class SettingFragment : Fragment(), SettingsFragmentInterface.View {
    @Inject
    lateinit var presenter: SettingsFragmentInterface.Presenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_setting, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ThisApp.appComponent.inject(this)

        lifecycle.addObserver(presenter)

        presenter.setView(this)
        presenter.init()
    }

    override fun init(profile: Profile?) {
        profile?.let {
            if (profile.avatar == null) {
                ivSettingsUserPhoto.setImageResource(R.drawable.ic_not_user_photo)
                ivSettingsUserPhotoFullSize.setImageResource(R.drawable.ic_not_user_photo)
            } else {
                val image = convertStringToBitmap(profile.avatar!!)
                ivSettingsUserPhoto.setImageBitmap(image)
                ivSettingsUserPhotoFullSize.setImageBitmap(image)
            }

            tvSettingsUserFIO.text = profile.fullName
        }
    }

    private fun convertStringToBitmap(string: String): Bitmap? {
        return BitmapFactory.decodeByteArray(
            Base64.decode(string, Base64.DEFAULT),
            0,
            Base64.decode(string, Base64.DEFAULT).size
        )
    }

    override fun setListeners() {
        ivSettingsUserPhoto.setOnClickListener { presenter.onIvUserPhotoClicked() }
        clSync.setOnClickListener { presenter.onSyncBtnClicked() }
        clLogOut.setOnClickListener { presenter.onLogoutBtnClicked() }
    }

    override fun openUserPhotoFullSize() {
        clSettingsUserPhotoFullSize.visibility = View.VISIBLE
    }

    override fun showSyncProgressBar(isShow: Boolean) {
        if (isShow) {
            pbSettingsSync.visibility = View.VISIBLE
            clSettingsParameters.visibility = View.INVISIBLE
        } else {
            pbSettingsSync.visibility = View.GONE
            clSettingsParameters.visibility = View.VISIBLE
        }
    }

    override fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    override fun openLoginActivity() {
        (activity as BaseActivity).let {
            it.navigator.showLogin(it)
            it.finish()
        }
    }

    override fun showError(failure: Failure) {
        (activity as BaseActivity).showError(failure)
    }

    fun onBackPressed(): Boolean {
        if (clSettingsUserPhotoFullSize.visibility == View.GONE)
            return false

        clSettingsUserPhotoFullSize.visibility = View.GONE
        return true
    }
}