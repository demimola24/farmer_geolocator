package com.example.farmerapp.configs

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.farmerapp.ui.MainViewModel
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
    @ViewModelKey(MainViewModel::class)
    abstract fun bindTransferViewModel(viewModel: MainViewModel): ViewModel


    /**
     * Provides the FarmerViewModelFactory
     * */

    @Binds
    abstract fun provideViewModelFactory(factory: MyViewModelFactory): ViewModelProvider.Factory


}