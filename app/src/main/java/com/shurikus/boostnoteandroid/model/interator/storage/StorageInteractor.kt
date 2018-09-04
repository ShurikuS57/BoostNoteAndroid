package com.shurikus.boostnoteandroid.model.interator.storage

import com.shurikus.boostnoteandroid.model.data.local.db.model.StorageModel
import com.shurikus.boostnoteandroid.model.repository.storage.StorageRepository
import io.reactivex.Single
import javax.inject.Inject

class StorageInteractor @Inject constructor(
        private val storageRepository: StorageRepository
){
    fun loadStorageList(): Single<List<StorageModel>> {
        return storageRepository.loadStorageList()
    }

}