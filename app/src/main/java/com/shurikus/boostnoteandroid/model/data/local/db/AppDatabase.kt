package com.shurikus.boostnoteandroid.model.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.shurikus.boostnoteandroid.model.data.local.db.dao.StorageDao
import com.shurikus.boostnoteandroid.model.data.local.db.model.StorageModel

@Database(entities = [StorageModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun taskDao(): StorageDao
}