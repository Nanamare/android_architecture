package com.nanamare.mac.sample.di

import com.nanamare.mac.sample.ui.market.MarketListFragment
import org.koin.androidx.fragment.dsl.fragment
import org.koin.dsl.module

val fragmentModule = module {
    fragment { (coinMap: LinkedHashMap<String, List<String>>) ->
        MarketListFragment(coinMap)
    }
}