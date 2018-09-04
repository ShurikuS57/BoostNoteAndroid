package com.shurikus.boostnoteandroid.ui.base

import androidx.annotation.StringRes
import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

interface BaseView : MvpView {
    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showToast(message: String)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showToast(@StringRes message: Int)
}