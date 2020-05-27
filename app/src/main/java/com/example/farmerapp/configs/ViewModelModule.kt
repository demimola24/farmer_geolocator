package com.example.farmerapp.configs

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.farmerapp.ui.farmer.NewFarmerViewModel
import com.example.farmerapp.ui.home.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


/**
 * @author Demimola on 29/01/2020
 * for MyFarmerApp
 **/

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindMainViewModel(viewModel: HomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(NewFarmerViewModel::class)
    abstract fun bindNewFarmerViewModel(viewModel: NewFarmerViewModel): ViewModel


    /**
     * Provides the FarmerViewModelFactory
     * */

    @Binds
    abstract fun provideViewModelFactory(factory: MyViewModelFactory): ViewModelProvider.Factory


}