package com.example.farmerapp.configs

import android.app.Application
import com.example.farmerapp.FarmerApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton


/**
 * @author Demimola on 29/01/2020
 * for MyFarmerApp
 **/

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        MainActivityModule::class]
)
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun appModule(appModule: AppModule): Builder
        fun build(): AppComponent
    }

    //    fun inject(application: Application)
    fun inject(application: FarmerApp)

}