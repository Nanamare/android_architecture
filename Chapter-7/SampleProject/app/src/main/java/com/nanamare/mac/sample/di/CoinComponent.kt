package com.nanamare.mac.sample.di

import com.nanamare.mac.sample.di.scope.ActivityScope
import com.nanamare.mac.sample.ui.MainActivity
import com.nanamare.mac.sample.ui.coin.CoinFragment
import dagger.Subcomponent

@ActivityScope
@Subcomponent
interface CoinComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create() : CoinComponent
    }

    fun inject(fragment: CoinFragment)
    fun inject(activity: MainActivity)

}