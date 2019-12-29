package com.nanamare.mac.sample

import android.app.Application
import android.content.Context
import com.nanamare.mac.sample.di.AppComponent
import com.nanamare.mac.sample.di.DaggerAppComponent

class AppApplication : Application() {

    val appComponent: AppComponent by lazy {
        initializeComponent()
    }

    // TODO using this in testing
    open fun initializeComponent(): AppComponent {
        return DaggerAppComponent.factory().create(applicationContext)
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    fun context(): Context = applicationContext

    companion object {
        lateinit var instance: AppApplication
            private set
    }

}
