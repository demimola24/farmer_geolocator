package com.example.farmerapp.configs

import com.example.farmerapp.ui.auth.SplashFragment
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
}