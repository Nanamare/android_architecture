package com.nanamare.mac.sample.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nanamare.mac.sample.base.BaseViewModel
import com.nanamare.mac.sample.data.market.MarketRepository
import com.nanamare.mac.sample.di.scope.ActivityScope
import javax.inject.Inject

@ActivityScope
class MarketViewModel @Inject constructor(
    private var marketRepository : MarketRepository
) : BaseViewModel() {

    private var _market = MutableLiveData<LinkedHashMap<String, List<String>>>()

    val market: LiveData<LinkedHashMap<String, List<String>>> get() = _market

    fun onMarketClick() {
        isLoadingObservable.value = true
        val marketMap: LinkedHashMap<String, List<String>> = LinkedHashMap()
        marketRepository.getMarketList(success = {
            val marketList = listOf<String>().toMutableList()
            it.map { marketModel ->
                marketModel.market!!.split("-")[0].let { market ->
                    marketList.add(marketModel.market)
                    marketMap.put(market, marketList)
                }
            }
            isLoadingObservable.value = false
            _market.value = marketMap
        }, failed = {
            isLoadingObservable.value = false
            _market.value = marketMap
        })
    }

    override fun close() {
        marketRepository.close()
    }

}