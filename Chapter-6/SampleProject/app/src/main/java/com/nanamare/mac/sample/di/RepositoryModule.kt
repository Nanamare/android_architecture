package com.nanamare.mac.sample.di

import com.nanamare.mac.sample.data.coin.CoinRemoteDataSource
import com.nanamare.mac.sample.data.coin.CoinRepository
import com.nanamare.mac.sample.data.coin.CoinSource
import com.nanamare.mac.sample.data.market.MarketRemoteDataSource
import com.nanamare.mac.sample.data.market.MarketRepository
import com.nanamare.mac.sample.data.market.MarketSource
import org.koin.dsl.module

val repositoryModule = module {
    single { CoinRepository(get()) as CoinSource }
    single { MarketRepository(get()) as MarketSource }
}

val dataSourceModule = module {
    single { CoinRemoteDataSource(get()) }
    single { MarketRemoteDataSource(get()) }
}