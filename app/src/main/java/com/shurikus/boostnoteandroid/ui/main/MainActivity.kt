package com.shurikus.boostnoteandroid.ui.main

import android.os.Bundle
import androidx.core.view.GravityCompat
import com.shurikus.boostnoteandroid.R
import com.shurikus.boostnoteandroid.di.DI
import com.shurikus.boostnoteandroid.ui.base.BaseActivity
import com.shurikus.boostnoteandroid.ui.drawer.NavigationDrawerFragment
import kotlinx.android.synthetic.main.activity_main.*
import toothpick.Toothpick

class MainActivity : BaseActivity() {

    override val layoutRes = R.layout.activity_main

    private val drawerFragment
        get() = supportFragmentManager.findFragmentById(R.id.navDrawerContainer) as NavigationDrawerFragment?

    override fun onCreate(savedInstanceState: Bundle?) {
        Toothpick.inject(this, Toothpick.openScope(DI.APP_SCOPE))
        super.onCreate(savedInstanceState)
        setupNavDrawable()
    }

    fun showNavMenu() {
        drawerLayout?.openDrawer(GravityCompat.START)
    }

    private fun setupNavDrawable() {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.navDrawerContainer, NavigationDrawerFragment())
                .commitNow()
    }
}
