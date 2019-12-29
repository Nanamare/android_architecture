package com.nanamare.mac.sample.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppSubComponent::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun injectCoinComponent(): CoinComponent.Factory
    fun injectMarketComponent(): MarketComponent.Factory

}