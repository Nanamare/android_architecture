package com.nanamare.mac.sample.di

import dagger.Module

@Module(subcomponents = [CoinComponent::class, MarketComponent::class])
class AppSubComponent