package com.example.testtaskapp.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import com.example.testtaskapp.R
import com.example.testtaskapp.databinding.FragmentRegisterBinding
import com.example.testtaskapp.util.initToolbar
import com.example.testtaskapp.util.showBottomSheet


class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar(binding.toolbar)
        initListerners()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initListerners(){

        binding.btnRegister.setOnClickListener(){
            validateData()

        }

    }

    private fun validateData(){

        val email = binding.edtEmail.text.toString().trim()
        val password = binding.edtPassword.text.toString().trim()

        if(email.isNotEmpty()){
            if(password.isNotEmpty()){

                binding.progressBar.isVisible = true

            }else{
                showBottomSheet(message = getString(R.string.password_empty_register_fragment))
            }

        }else{
            showBottomSheet(message = getString(R.string.email_empty_register_fragment))
        }

    }

}




