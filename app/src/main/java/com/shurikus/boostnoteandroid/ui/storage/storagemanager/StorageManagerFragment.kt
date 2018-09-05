package com.shurikus.boostnoteandroid.ui.storage.storagemanager

import android.os.Bundle
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.shurikus.boostnoteandroid.R
import com.shurikus.boostnoteandroid.di.DI
import com.shurikus.boostnoteandroid.presentation.storage.storagemanger.StorageManagerPresenter
import com.shurikus.boostnoteandroid.presentation.storage.storagemanger.StorageManagerView
import com.shurikus.boostnoteandroid.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_storage_manager.*
import toothpick.Toothpick

class StorageManagerFragment : BaseFragment(), StorageManagerView {
    override val layoutRes = R.layout.fragment_storage_manager
    override val navigatorRes = R.id.storage_nav_host

    @InjectPresenter
    lateinit var presenter: StorageManagerPresenter

    @ProvidePresenter
    fun providePresenter(): StorageManagerPresenter {
        return Toothpick
                .openScope(DI.APP_SCOPE)
                .getInstance(StorageManagerPresenter::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onViewCreated()
        fab.setOnClickListener {
            presenter.onAddStorageClicked()
        }
        toolbar.setNavigationOnClickListener {
            requireActivity().onBackPressed()
        }
    }

    override fun showEmptyStoragePlaceHolder() {
        // Todo need implement
    }

    override fun goToAddStorageScreen() {
        navigator?.navigate(R.id.action_storageListFragment_to_addStorageFragment)
    }
}