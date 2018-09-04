package com.shurikus.boostnoteapclassp.ui.storage.addstorage

import com.shurikus.boostnoteandroid.R
import com.shurikus.boostnoteandroid.presentation.storage.activity.StorageView
import com.shurikus.boostnoteandroid.ui.base.BaseFragment

class AddStorageFragment : BaseFragment(), StorageView {
    override val layoutRes: Int = R.layout.fragment_add_storage
    override val navigatorRes: Int = R.id.storage_nav_host

}