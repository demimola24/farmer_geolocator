package com.example.farmerapp.configs

import com.example.farmerapp.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


/**
 * @author Demimola on 29/01/2020
 * for MyFarmerApp
 **/


@Suppress("unused")
@Module
abstract class MainActivityModule {
    @ContributesAndroidInjector(modules = [FragmentBuildersModule::class])
    abstract fun contributeMainActivity(): MainActivity
}