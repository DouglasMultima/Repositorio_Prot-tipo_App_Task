package com.example.testtaskapp.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import com.example.testtaskapp.R
import com.example.testtaskapp.databinding.FragmentFormTaskBinding
import com.example.testtaskapp.databinding.FragmentRecoverAccountBinding
import com.example.testtaskapp.util.initToolbar
import com.example.testtaskapp.util.showBottomSheet
import com.google.android.material.internal.ViewUtils.hideKeyboard


class RecoverAccountFragment : Fragment() {

    private var _binding: FragmentRecoverAccountBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        _binding = FragmentRecoverAccountBinding.inflate(inflater,container,false)
        return (binding.root)
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

        binding.btnRecover.setOnClickListener(){
            validateData()

        }

    }

    private fun validateData() {

        val email = binding.edtEmail.text.toString().trim()


        if (email.isNotEmpty()) {

            findNavController().navigate(R.id.action_global_homeFragment)

        } else {
            showBottomSheet(message = getString(R.string.email_empty))
        }

    }
}