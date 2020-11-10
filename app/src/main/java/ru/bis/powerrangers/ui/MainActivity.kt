package ru.bis.powerrangers.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import ru.bis.powerrangers.R

class MainActivity : BaseActivity(), ContentContract.View {
    private lateinit var presenter: ContentContract.Presenter
    private lateinit var fragmentManager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content)

        ThisApp.appComponent.inject(this)

        presenter = ContentActivityPresenter()
        presenter.apply {
            setView(this@ContentActivity)
            init()
        }
    }

    override fun initViews() {
        fragmentManager = supportFragmentManager
        openDefaultFragment()
    }

    override fun setListeners() {
        bottom_navigation_view.setOnNavigationItemSelectedListener {
            onNavigationBtnClicked(it.itemId)
            true
        }
    }

    private fun openDefaultFragment() {
        fragmentManager.beginTransaction().replace(R.id.rootLayout, OkvFragment.newInstance()).commit()
    }

  /*  private fun onNavigationBtnClicked(itemId: Int) {
        when (itemId) {
            R.id.nav_item_auto_statistics -> changeFragment(DIAGNOSTICS_AUTO, null, false)
            R.id.nav_item_settings -> changeFragment(SETTING_FRAGMENT, null, false)
        }
    }*/
}