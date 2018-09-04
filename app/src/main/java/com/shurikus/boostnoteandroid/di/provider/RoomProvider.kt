package com.shurikus.boostnoteandroid.di.provider

import android.content.Context
import androidx.room.Room
import com.shurikus.boostnoteandroid.model.data.local.db.AppDatabase
import javax.inject.Inject
import javax.inject.Provider

class RoomProvider @Inject constructor(private val context: Context) : Provider<AppDatabase> {
    override fun get(): AppDatabase =
            Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "boostnote.db")
                    .fallbackToDestructiveMigration()
                    .build()
}