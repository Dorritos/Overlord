package ru.bis.powerrangers.helpers

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import ru.bis.powerrangers.R

fun AppCompatActivity?.replaceFragment(fragment: Fragment, fraggmentStr: String, addToBackStack: Boolean){
    this?.supportFragmentManager?.beginTransaction().apply {
        this?.replace(R.id.rootLayout, fragment, fraggmentStr)
        if(addToBackStack)
            this?.addToBackStack(null)
        this?.commit()
    }
}

fun AppCompatActivity.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}