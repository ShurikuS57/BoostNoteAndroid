package com.shurikus.boostnoteandroid

import android.app.Application
import com.shurikus.boostnoteandroid.di.DI
import com.shurikus.boostnoteandroid.di.module.AppModule
import toothpick.Toothpick
import toothpick.configuration.Configuration
import toothpick.registries.FactoryRegistryLocator
import toothpick.registries.MemberInjectorRegistryLocator

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        initToothpick()
        initAppScope()
    }

    private fun initToothpick() {
        if (BuildConfig.DEBUG) {
            Toothpick.setConfiguration(Configuration.forDevelopment().preventMultipleRootScopes())
        } else {
            Toothpick.setConfiguration(Configuration.forProduction().disableReflection())
            FactoryRegistryLocator.setRootRegistry(com.shurikus.boostnoteandroid.FactoryRegistry())
            MemberInjectorRegistryLocator.setRootRegistry(com.shurikus.boostnoteandroid.MemberInjectorRegistry())
        }
    }

    private fun initAppScope() {
        val appScope = Toothpick.openScope(DI.APP_SCOPE)
        appScope.installModules(AppModule(this))
    }

}