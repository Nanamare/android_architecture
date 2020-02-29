package com.nanamare.mac.sample.ui

import android.os.Bundle
import androidx.lifecycle.Observer
import com.nanamare.mac.sample.R
import com.nanamare.mac.sample.base.BaseActivity
import com.nanamare.mac.sample.databinding.ActivityMainBinding
import com.nanamare.mac.sample.ui.market.MarketListFragment
import com.nanamare.mac.sample.vm.MarketViewModel
import org.koin.android.ext.android.inject
import org.koin.androidx.fragment.android.setupKoinFragmentFactory
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val marketListFragment by inject<MarketListFragment> {
        parametersOf(coins)
    }

    val tlMarket
        get() = binding.tlMarketList

    private val marketVM: MarketViewModel by viewModel()

    private var coins: LinkedHashMap<String, List<String>> = LinkedHashMap()

    override fun onCreate(savedInstanceState: Bundle?) {
        setupKoinFragmentFactory()
        super.onCreate(savedInstanceState)

        with(marketVM) {
            onMarketClick()
            market.observe(this@MainActivity, Observer {
                coins = it
                goToFragment(marketListFragment)
            })

            isLoadingObservable.observe(this@MainActivity, Observer {
                when {
                    it -> showLoadingDialog()
                    else -> hideLoadingDialog()
                }
            })

        }
    }

}
