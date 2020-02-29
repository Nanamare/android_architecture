package com.nanamare.mac.sample.ui.market

import android.os.Bundle
import android.view.View
import com.nanamare.mac.sample.R
import com.nanamare.mac.sample.adapter.MarketListViewPager
import com.nanamare.mac.sample.base.BaseFragment
import com.nanamare.mac.sample.databinding.FragmentMarketListViewpagerBinding
import com.nanamare.mac.sample.ui.MainActivity
import com.nanamare.mac.sample.ui.coin.CoinFragment


class MarketListFragment(private val marketMap: HashMap<String, List<String>>) :
    BaseFragment<FragmentMarketListViewpagerBinding>(R.layout.fragment_market_list_viewpager) {

    private val marketListViewPager: MarketListViewPager by lazy {
        MarketListViewPager(
            childFragmentManager
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(binding)
    }

    private fun initView(binding: FragmentMarketListViewpagerBinding) {
        binding.run {
            marketMap.map {
                marketListViewPager.addFragment(CoinFragment.newInstance(it.value, it.key), it.key)
            }
            coinViewPager.adapter = marketListViewPager
            (requireActivity() as MainActivity).tlMarket.setupWithViewPager(coinViewPager)
        }
    }

}
