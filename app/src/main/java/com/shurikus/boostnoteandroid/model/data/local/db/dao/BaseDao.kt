package com.shurikus.boostnoteandroid.model.data.local.db.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update

interface BaseDao<in T> {
    @Insert
    fun insert(obj: T): Long

    @Insert
    fun insert(vararg obj: T)

    @Update
    fun update(obj: T)

    @Delete
    fun delete(obj: T)
}