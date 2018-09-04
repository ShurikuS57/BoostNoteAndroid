package com.shurikus.boostnoteandroid.model.data.local.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.shurikus.boostnoteandroid.model.data.local.db.model.StorageModel
import io.reactivex.Single

@Dao
interface StorageDao : BaseDao<StorageModel> {

    @Query("SELECT * FROM storage_table")
    fun getStorageList(): Single<List<StorageModel>>
}