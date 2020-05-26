package com.example.farmerapp.ui.base

import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.farmerapp.configs.Injectable
import javax.inject.Inject


interface ToolbarFragment {
    val showToolBar: Boolean
}

abstract class BaseFragment : Fragment(),ToolbarFragment, Injectable {

    override val showToolBar = true

    @Inject
    lateinit var viewModelProviderFactory: ViewModelProvider.Factory

}