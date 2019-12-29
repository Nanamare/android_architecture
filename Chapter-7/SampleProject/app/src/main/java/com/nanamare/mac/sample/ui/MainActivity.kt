package com.nanamare.mac.sample.ui

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.gson.Gson
import com.nanamare.mac.sample.AppApplication
import com.nanamare.mac.sample.R
import com.nanamare.mac.sample.base.BaseActivity
import com.nanamare.mac.sample.databinding.ActivityMainBinding
import com.nanamare.mac.sample.di.CoinComponent
import com.nanamare.mac.sample.di.MarketComponent
import com.nanamare.mac.sample.ext.createFactory
import com.nanamare.mac.sample.ui.market.MarketListFragment
import com.nanamare.mac.sample.vm.CoinViewModel
import com.nanamare.mac.sample.vm.MarketViewModel
import javax.inject.Inject

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    lateinit var coinComponent: CoinComponent
    lateinit var marketComponent: MarketComponent

    @Inject
    lateinit var marketVM : MarketViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        marketComponent = (application as AppApplication).appComponent.injectMarketComponent().create()
        marketComponent.inject(this)
        coinComponent = (application as AppApplication).appComponent.injectCoinComponent().create()
        coinComponent.inject(this)
        super.onCreate(savedInstanceState)

        with(marketVM) {
            onMarketClick()

            market.observe(this@MainActivity, Observer {
                gotoFragment(it)
            })

            isLoadingObservable.observe(this@MainActivity, Observer {
                when {
                    it -> showLoadingDialog()
                    else -> hideLoadingDialog()
                }
            })

        }

    }

    private fun gotoFragment(it: LinkedHashMap<String, List<String>>) {
        val bundle = Bundle().apply {
            putString(KET_MARKET_LIST, Gson().toJson(it))
        }
        goToFragment(MarketListFragment::class.java, bundle)
    }

}
