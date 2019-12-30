package com.nanamare.mac.sample.di

import com.nanamare.mac.sample.di.scope.ActivityScope
import com.nanamare.mac.sample.ui.MainActivity
import com.nanamare.mac.sample.ui.market.MarketListFragment
import dagger.Subcomponent

@ActivityScope
@Subcomponent
interface MarketComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create() : MarketComponent
    }

    fun inject(fragment: MarketListFragment)
    fun inject(activity: MainActivity)

}