package com.shurikus.boostnoteandroid.di.module

import android.content.Context
import android.content.res.AssetManager
import com.google.gson.Gson
import com.shurikus.boostnoteandroid.di.provider.GsonProvider
import com.shurikus.boostnoteandroid.di.provider.RoomProvider
import com.shurikus.boostnoteandroid.model.data.local.RawAppData
import com.shurikus.boostnoteandroid.model.data.local.db.AppDatabase
import com.shurikus.boostnoteandroid.model.system.AppSchedulers
import com.shurikus.boostnoteandroid.model.system.ResourceManager
import com.shurikus.boostnoteandroid.model.system.SchedulersProvider
import toothpick.config.Module

class AppModule(context: Context) : Module() {
    init {
        bind(Context::class.java).toInstance(context)
        bind(ResourceManager::class.java).singletonInScope()
        bind(AssetManager::class.java).toInstance(context.assets)
        bind(RawAppData::class.java)
        bind(SchedulersProvider::class.java).toInstance(AppSchedulers())
        bind(Gson::class.java).toProvider(GsonProvider::class.java).providesSingletonInScope()
        bind(AppDatabase::class.java).toProvider(RoomProvider::class.java).providesSingletonInScope()
    }
}