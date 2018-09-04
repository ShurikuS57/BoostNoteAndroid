package com.shurikus.boostnoteandroid.presentation.drawer

import com.arellomobile.mvp.InjectViewState
import com.shurikus.boostnoteandroid.ui.base.BasePresenter
import com.shurikus.boostnoteandroid.ui.drawer.NavigationDrawerView

@InjectViewState
class NavigationDrawerPresenter : BasePresenter<NavigationDrawerView>() {
    fun onStorageManagerClicked() {
        viewState.goToStorageManagerScreen()
    }
}