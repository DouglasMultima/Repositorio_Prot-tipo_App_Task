package com.example.testtaskapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testtaskapp.R
import com.example.testtaskapp.data.model.Status
import com.example.testtaskapp.data.model.Task
import com.example.testtaskapp.databinding.FragmentHomeBinding
import com.example.testtaskapp.databinding.FragmentTodoBinding
import com.example.testtaskapp.ui.adapter.TaskAdapter


class TodoFragment : Fragment() {

    private var _binding: FragmentTodoBinding? = null
    private val binding get() = _binding!!

    private lateinit var taskAdapter: TaskAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        _binding= FragmentTodoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()

        initRecycleView()
        getTask()

    }

    private fun initListeners(){
        binding.fabAdd.setOnClickListener{
            findNavController().navigate(R.id.action_homeFragment_to_formTaskFragment)
        }
    }

    private fun initRecycleView(){

        taskAdapter = TaskAdapter(requireContext()){ task, option->
            optionSelected(task,option)
        }
        with(binding.rvTask){

            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
            adapter = taskAdapter
        }


    }

    private fun optionSelected(task:Task,option: Int){
            when(option){
                TaskAdapter.SELECT_REMOVE -> {
                    Toast.makeText(requireContext(), "Removendo ${task.description}", Toast.LENGTH_SHORT).show()
                }
                TaskAdapter.SELECT_EDIT -> {
                    Toast.makeText(requireContext(), "Editando ${task.description}", Toast.LENGTH_SHORT).show()
                }

                TaskAdapter.SELECT_DETAILS -> {
                    Toast.makeText(requireContext(), "Detalhes ${task.description}", Toast.LENGTH_SHORT).show()
                }

                TaskAdapter.SELECT_NEXT -> {
                    Toast.makeText(requireContext(), "Next ${task.description}", Toast.LENGTH_SHORT).show()
                }
            }

    }

    private fun getTask() {

          val taskList = listOf(
              Task("0","A vida é excelente",Status.TODO),
              Task("1", "Coisas que podemos fazer",Status.TODO),
              Task("2", "Como fazer um item",Status.TODO),
              Task("3", "Imaginando uma vida",Status.TODO),
              Task("4", "Legal e internacional",Status.TODO)
          )

        taskAdapter.submitList(taskList)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}