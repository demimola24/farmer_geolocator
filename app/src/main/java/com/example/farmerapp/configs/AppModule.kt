package com.example.farmerapp.configs

import android.content.Context
import com.example.farmerapp.FarmerApp
import com.example.farmerapp.db.Repository
import com.example.farmerapp.db.database.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @author Demimola on 29/01/2020
 * for MyFarmerApp
 **/

@Module(includes = [ViewModelModule::class])
class AppModule(val app: FarmerApp) {
    @Singleton
    @Provides
    internal fun provideContext(): Context {
        return app.applicationContext
    }

    @Singleton
    @Provides
    internal fun provideRoomDatabase(context: Context): AppDatabase {
        return AppDatabase.getInstance(context)
    }

    @Singleton
    @Provides
    internal fun provideReository(db: AppDatabase): Repository {
        return Repository( db)
    }
}