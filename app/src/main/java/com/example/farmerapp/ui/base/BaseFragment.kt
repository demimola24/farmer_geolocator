package com.example.farmerapp.ui.base

import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.farmerapp.configs.Injectable
import javax.inject.Inject
import android.content.DialogInterface
import androidx.appcompat.app.AlertDialog




interface ToolbarFragment {
    val showToolBar: Boolean
}

abstract class BaseFragment : Fragment(),ToolbarFragment, Injectable {

    override val showToolBar = true

    @Inject
    lateinit var viewModelProviderFactory: ViewModelProvider.Factory

    fun showErrorDialog(title: String = "Oops!",message: String = "An error occurred"){
        val dialogClickListener = DialogInterface.OnClickListener { dialog, which ->
            when (which) {
                DialogInterface.BUTTON_POSITIVE -> {
                }

                DialogInterface.BUTTON_NEGATIVE -> {
                }
            }//Yes button clicked
            //No button clicked
        }

        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle(title)
        builder.setMessage(message)
            .setNegativeButton("Retry", dialogClickListener).show()
    }

    fun showInfoDialog(title: String = "Info",message: String = " "){
        val dialogClickListener = DialogInterface.OnClickListener { dialog, which ->
            when (which) {
                DialogInterface.BUTTON_POSITIVE -> {
                }

                DialogInterface.BUTTON_NEGATIVE -> {
                }
            }//Yes button clicked
            //No button clicked
        }

        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle(title)
        builder.setMessage(message).setPositiveButton("Okay", dialogClickListener).show()
    }

}