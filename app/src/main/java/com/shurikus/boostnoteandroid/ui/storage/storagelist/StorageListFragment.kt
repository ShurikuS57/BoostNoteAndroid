package com.shurikus.boostnoteandroid.ui.storage.storagelist

import android.os.Bundle
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.shurikus.boostnoteandroid.R
import com.shurikus.boostnoteandroid.di.DI
import com.shurikus.boostnoteandroid.presentation.storage.storagelist.StorageListPresenter
import com.shurikus.boostnoteandroid.presentation.storage.storagelist.StorageListView
import com.shurikus.boostnoteandroid.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_storage_list.*
import toothpick.Toothpick

class StorageListFragment : BaseFragment(), StorageListView {
    override val layoutRes = R.layout.fragment_storage_list
    override val navigatorRes = R.id.storage_nav_host

    @InjectPresenter
    lateinit var presenter: StorageListPresenter

    @ProvidePresenter
    fun providePresenter(): StorageListPresenter {
        return Toothpick
                .openScope(DI.APP_SCOPE)
                .getInstance(StorageListPresenter::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onViewCreated()
        fab.setOnClickListener {
            presenter.onAddStorageClicked()
        }
    }

    override fun showEmptyStoragePlaceHolder() {
        // Todo need implement
    }

    override fun goToAddStorageScreen() {
        navigator?.navigate(R.id.action_storageListFragment_to_addStorageFragment)
    }
}