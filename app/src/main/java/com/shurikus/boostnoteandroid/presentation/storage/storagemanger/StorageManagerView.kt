package com.shurikus.boostnoteandroid.presentation.storage.storagemanger

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.shurikus.boostnoteandroid.ui.base.BaseView

@StateStrategyType(AddToEndSingleStrategy::class)
interface StorageManagerView : BaseView {

    fun showEmptyStoragePlaceHolder()

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun goToAddStorageScreen()
}