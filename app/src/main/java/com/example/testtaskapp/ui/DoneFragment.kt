package com.example.testtaskapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testtaskapp.data.model.Status
import com.example.testtaskapp.data.model.Task
import com.example.testtaskapp.databinding.FragmentDoneBinding
import com.example.testtaskapp.ui.adapter.TaskAdapter


class DoneFragment : Fragment() {

    private var _binding: FragmentDoneBinding? = null
    private val binding get() = _binding!!

    private lateinit var taskAdapter: TaskAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        _binding = FragmentDoneBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        initRecycleView()
        getTask()

    }


    private fun initRecycleView(){

        taskAdapter = TaskAdapter(requireContext()){ task, option ->
            getTask()
        }

        binding.rvTask.layoutManager = LinearLayoutManager(requireContext())
        binding.rvTask.setHasFixedSize(true)
        binding.rvTask.adapter = taskAdapter

    }

    private fun getTask(){

        val taskList =  listOf(
            Task("0","Observando lista", Status.DONE),
            Task("1", " problemas definidos", Status.DONE),
            Task("2", "Metas da ano", Status.DONE),
            Task("3", "Semana que vem", Status.DONE),
            Task("4", "Objetivo excluido", Status.DONE),
        )

        taskAdapter.submitList(taskList)



    }

    private fun optionSelected(task:Task,option: Int){

        when(option){

            TaskAdapter.SELECT_BACK -> {
                Toast.makeText(requireContext(), "Back ${task.description}", Toast.LENGTH_SHORT).show()
            }

            TaskAdapter.SELECT_REMOVE -> {
                Toast.makeText(requireContext(), "Removendo ${task.description}", Toast.LENGTH_SHORT).show()
            }
            TaskAdapter.SELECT_EDIT -> {
                Toast.makeText(requireContext(), "Editando ${task.description}", Toast.LENGTH_SHORT).show()
            }

            TaskAdapter.SELECT_DETAILS -> {
                Toast.makeText(requireContext(), "Detalhes ${task.description}", Toast.LENGTH_SHORT).show()
            }


        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}