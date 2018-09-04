package com.shurikus.boostnoteandroid.presentation.storage.activity

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.shurikus.boostnoteandroid.ui.base.BaseView

@StateStrategyType(AddToEndSingleStrategy::class)
interface StorageView : BaseView {

}