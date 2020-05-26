package com.example.farmerapp.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.farmerapp.R
import com.example.farmerapp.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : BaseFragment() {
    override val showToolBar: Boolean
        get() = false


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_login.setOnClickListener {
            localValidation()
        }
    }

    private fun localValidation() {
        val email  = til_email.editText?.text.toString()
        val passWord  = til_password.editText?.text.toString()
        if(email.isEmpty() || email != "test@theagromall.com"){
            showErrorDialog(message="Invalid email address")
            return
        }
        if(passWord.isEmpty() || passWord != "password"){
            showErrorDialog(message = "Invalid password")
            return
        }
        gotoHome()
    }

    private fun gotoHome() {
          findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
    }

}