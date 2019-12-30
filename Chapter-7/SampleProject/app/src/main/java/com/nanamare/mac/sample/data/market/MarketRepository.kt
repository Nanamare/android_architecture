package com.nanamare.mac.sample.data.market

import com.nanamare.mac.sample.api.upbit.MarketModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MarketRepository @Inject constructor(
    private val marketRemoteDataSource: MarketRemoteDataSource
) : MarketSource {

    override fun getMarketList(success: (List<MarketModel>) -> Unit, failed: () -> Unit) {
        marketRemoteDataSource.getMarketList(success, failed)
    }

    override fun close() {
        marketRemoteDataSource.close()
    }


}