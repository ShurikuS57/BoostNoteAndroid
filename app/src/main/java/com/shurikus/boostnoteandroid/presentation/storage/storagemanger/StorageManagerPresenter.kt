package com.shurikus.boostnoteandroid.presentation.storage.storagemanger

import com.arellomobile.mvp.InjectViewState
import com.shurikus.boostnoteandroid.R
import com.shurikus.boostnoteandroid.model.interator.storage.StorageInteractor
import com.shurikus.boostnoteandroid.ui.base.BasePresenter
import javax.inject.Inject

@InjectViewState
class StorageManagerPresenter @Inject constructor(
        private val storageInteractor: StorageInteractor
) : BasePresenter<StorageManagerView>() {

    fun onViewCreated() {
        disposable.add(storageInteractor
                .loadStorageList()
                .subscribe({
                    if (it.isEmpty()) {
                        viewState.showEmptyStoragePlaceHolder()
                    } else {

                    }
                }, {
                    viewState.showToast(R.string.error_load_storage_list)
                }))
    }

    fun onAddStorageClicked() {
        viewState.goToAddStorageScreen()
    }
}