package com.shurikus.boostnoteandroid.ui.storage.storageactivity

import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.shurikus.boostnoteandroid.R
import com.shurikus.boostnoteandroid.di.DI
import com.shurikus.boostnoteandroid.presentation.storage.activity.StoragePresenter
import com.shurikus.boostnoteandroid.presentation.storage.activity.StorageView
import com.shurikus.boostnoteandroid.ui.base.BaseActivity
import toothpick.Toothpick

class StorageActivity : BaseActivity(), StorageView {
    override val layoutRes = R.layout.activity_storage

    @InjectPresenter
    lateinit var presenter: StoragePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        Toothpick.inject(this, Toothpick.openScope(DI.APP_SCOPE))
        super.onCreate(savedInstanceState)
    }

}