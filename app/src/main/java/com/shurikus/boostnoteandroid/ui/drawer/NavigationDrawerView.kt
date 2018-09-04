package com.shurikus.boostnoteandroid.ui.drawer

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.shurikus.boostnoteandroid.ui.base.BaseView

@StateStrategyType(AddToEndSingleStrategy::class)
interface NavigationDrawerView : BaseView {

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun goToStorageManagerScreen()
}