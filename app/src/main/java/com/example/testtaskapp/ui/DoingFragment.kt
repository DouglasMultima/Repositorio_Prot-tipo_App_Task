package com.example.testtaskapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testtaskapp.R
import com.example.testtaskapp.data.model.Status
import com.example.testtaskapp.data.model.Task
import com.example.testtaskapp.databinding.FragmentDoingBinding
import com.example.testtaskapp.ui.adapter.TaskAdapter


class DoingFragment : Fragment() {

    private var _binding: FragmentDoingBinding? = null
    private val binding get() = _binding!!

    private lateinit var taskAdapter: TaskAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        _binding = FragmentDoingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        initRecycleView()
        getTask()



    }

    private fun initRecycleView(){

        taskAdapter = TaskAdapter(requireContext()){task,option ->
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

            TaskAdapter.SELECT_NEXT -> {
                Toast.makeText(requireContext(), "Next ${task.description}", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun getTask(){
        val taskList = listOf(
            Task("0","Criar nova tarefa do app", Status.DOING),
            Task("1", "Solucionar problemas", Status.DOING),
            Task("2", "Metas da semana", Status.DOING),
            Task("3", "O que fazer amanhã", Status.DOING),
            Task("4", "Coisas da vida", Status.DOING),

            )

        taskAdapter.submitList(taskList)



    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}