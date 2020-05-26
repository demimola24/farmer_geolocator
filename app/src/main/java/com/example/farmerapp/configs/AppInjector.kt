package com.example.farmerapp.configs

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.Farmerfintech.app.FarmerApp
import com.Farmerfintech.app.utils.ActivityLifecycleCallbackAdapter
import com.Farmerfintech.app.utils.Constants
import dagger.android.AndroidInjection
import dagger.android.HasAndroidInjector
import dagger.android.support.AndroidSupportInjection

/**
 * @author Demimola Hanks on 2/13/18.
 * Main Injector Class
 * */
class AppInjector {

    companion object {

        fun init(app: FarmerApp) {
            DaggerAppComponent.builder()
                .application(app)
                .appModule(AppModule(app))
                .sharedPreferencesModule(SharedPrefModule(app, Constants.SHARED_PREF_NAME))
                .build()
                .also { app.appComponent = it }
                .inject(app)

            app.registerActivityLifecycleCallbacks(object : ActivityLifecycleCallbackAdapter() {
                override fun onActivityCreated(activity: Activity, bundle: Bundle?) {
                    super.onActivityCreated(activity, bundle)
                    handleActivity(activity)
                }
            })
        }

        fun handleActivity(activity: Activity) {
            if (activity is HasAndroidInjector) {
                AndroidInjection.inject(activity)
            }

            (activity as? FragmentActivity)?.supportFragmentManager?.registerFragmentLifecycleCallbacks(
                object : FragmentManager.FragmentLifecycleCallbacks() {

                    override fun onFragmentPreAttached(
                        fm: FragmentManager,
                        f: Fragment,
                        context: Context
                    ) {
                        super.onFragmentPreAttached(fm, f, context)

                        if (f is Injectable) {
                            AndroidSupportInjection.inject(f)
                        }
                    }
                }, true
            )

        }
    }

}
