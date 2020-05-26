package com.example.farmerapp.configs

import com.example.farmerapp.ui.auth.LoginFragment
import com.example.farmerapp.ui.auth.SplashFragment
import com.example.farmerapp.ui.home.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


/**
 * @author Demimola on 29/01/2020
 * for MyFarmerApp
 **/

@Module
abstract class FragmentBuildersModule {
    /**Features*/
    @ContributesAndroidInjector
    @FeatureScope
    internal abstract fun contributeSplashFragment(): SplashFragment


    @ContributesAndroidInjector
    @FeatureScope
    internal abstract fun contributeLoginFragment(): LoginFragment

    @ContributesAndroidInjector
    @FeatureScope
    internal abstract fun contributeHomeFragment(): HomeFragment



}