package com.shurikus.boostnoteandroid.ui.base

import com.arellomobile.mvp.MvpPresenter
import com.arellomobile.mvp.MvpView
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class BasePresenter<V : MvpView> : MvpPresenter<V>() {

    protected val disposable = CompositeDisposable()

    override fun onDestroy() {
        disposable.dispose()
    }

    protected fun Disposable.connect() {
        disposable.add(this)
    }
}