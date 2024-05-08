package com.example.testtaskapp.util

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.testtaskapp.R
import com.example.testtaskapp.databinding.BottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

fun Fragment.initToolbar(toolbar: Toolbar){

    (activity as AppCompatActivity).setSupportActionBar(toolbar)
    (activity as AppCompatActivity).title = "" // preenchimento de texto no layout vazio, receber os textos de cada fragment
    (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true) // mostrar a seta true == s ou  false == n//
    toolbar.setNavigationOnClickListener{activity?.onBackPressed()} // fazer o botão voltar retornar a pagina anterior



}

fun Fragment.showBottomSheet(
    titleDialog: Int? = null,
    titleButton: Int? = null,
    message: String,
    onClick:() -> Unit = {}

){

    val bottomSheetDialog = BottomSheetDialog(requireContext(), R.style.BottomSheetDialog)
    val binding : BottomSheetBinding =
        BottomSheetBinding.inflate(layoutInflater, null, false)

    binding.txtTitle.text = getText(titleDialog ?: R.string.text_title_warning)
    binding.txtMessage.text = message
    binding.btnOk.text = getText(titleButton ?: R.string.text_button_warning)
    binding.btnOk.setOnClickListener{
        onClick()
        bottomSheetDialog.dismiss()

    }

    bottomSheetDialog.setContentView(binding.root)
    bottomSheetDialog.show()

}