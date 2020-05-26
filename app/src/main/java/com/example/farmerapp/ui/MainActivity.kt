package com.example.farmerapp.ui

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.farmerapp.R
import com.example.farmerapp.ui.base.ToolbarFragment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector

import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>


    private val navController by lazy {
        findNavController(R.id.nav_host_fragment)
    }

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.splashFragment,
                R.id.loginFragment,
                R.id.homeFragment
            ), null
        ) {
            return@AppBarConfiguration true
        }
        toolbar.setupWithNavController(navController, appBarConfiguration)
        (this as FragmentActivity).supportFragmentManager.registerFragmentLifecycleCallbacks(
            fragLifecycleCallbacks,
            true
        )

    }

    override fun onSupportNavigateUp() = navController.navigateUp()

    private val fragLifecycleCallbacks = object : FragmentManager.FragmentLifecycleCallbacks() {
        override fun onFragmentResumed(fm: FragmentManager, f: Fragment) {
            super.onFragmentResumed(fm, f)

            (f as? ToolbarFragment)?.apply {
                if (f.showToolBar) {
                    toolbar.visibility = View.VISIBLE
                } else {
                    toolbar.visibility = View.GONE

                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onDestroy() {
        super.onDestroy()
        (this as FragmentActivity).supportFragmentManager.unregisterFragmentLifecycleCallbacks(
            fragLifecycleCallbacks
        )
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return androidInjector
    }
}
