package com.example.testtaskapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import com.example.testtaskapp.R
import com.example.testtaskapp.databinding.FragmentFormTaskBinding
import com.example.testtaskapp.databinding.FragmentRecoverAccountBinding
import com.example.testtaskapp.util.initToolbar
import com.example.testtaskapp.util.showBottomSheet


class FormTaskFragment : Fragment() {

    private var _binding: FragmentFormTaskBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        _binding = FragmentFormTaskBinding.inflate(inflater,container,false)
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

        binding.btnSave.setOnClickListener(){
            validateData()

        }

    }

    private fun validateData(){

        val description = binding.edtDescription.text.toString().trim()


        if(description.isNotEmpty()){



            binding.progressBar.isVisible = true


        }else{
            showBottomSheet(message = getString(R.string.description_empty_form_task_fragment))
        }


    }




}