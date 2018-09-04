package com.shurikus.boostnoteandroid.model.repository.storage

import com.shurikus.boostnoteandroid.model.data.local.db.AppDatabase
import com.shurikus.boostnoteandroid.model.data.local.db.model.StorageModel
import com.shurikus.boostnoteandroid.model.system.SchedulersProvider
import io.reactivex.Single
import javax.inject.Inject

class StorageRepository @Inject constructor(
        private val appDatabase: AppDatabase,
        private val schedulers: SchedulersProvider
) {

    fun loadStorageList(): Single<List<StorageModel>> = appDatabase
            .taskDao()
            .getStorageList()
            .subscribeOn(schedulers.io())
            .observeOn(schedulers.ui())
}