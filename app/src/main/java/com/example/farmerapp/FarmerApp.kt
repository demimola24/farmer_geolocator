package com.example.farmerapp

import android.app.Application
import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.example.farmerapp.configs.AppComponent
import com.example.farmerapp.configs.AppInjector
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class FarmerApp : Application(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>



    override fun onCreate() {
        super.onCreate()

        //init injector
        AppInjector.init(this)
    }

    lateinit var appComponent: AppComponent

    companion object {
        @JvmStatic
        fun coreComponent(context: Context) =
            (context.applicationContext as FarmerApp).appComponent
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return androidInjector
    }
}