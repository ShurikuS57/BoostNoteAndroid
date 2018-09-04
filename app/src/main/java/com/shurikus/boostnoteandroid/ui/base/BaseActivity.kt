package com.shurikus.boostnoteandroid.ui.base

import android.os.Bundle
import android.widget.Toast
import androidx.annotation.StringRes
import com.arellomobile.mvp.MvpAppCompatActivity

abstract class BaseActivity : MvpAppCompatActivity(), BaseView {

    protected abstract val layoutRes: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutRes)
    }

    override fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun showToast(@StringRes message: Int) {
        showToast(getString(message))
    }

}