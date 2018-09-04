package com.shurikus.boostnoteandroid.model.data.local.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "storage_table")
data class StorageModel(
        @PrimaryKey(autoGenerate = true)
        val id: Long,
        val name: String,
        val path: String
)