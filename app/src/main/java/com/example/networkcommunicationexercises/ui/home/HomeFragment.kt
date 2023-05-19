package com.example.networkcommunicationexercises.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.networkcommunicationexercises.R
import com.example.networkcommunicationexercises.databinding.FragmentHomeBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private var counter = 0


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.buttonHome.setOnClickListener {
            viewLifecycleOwner.lifecycleScope.launch {
                delayValueAndAddOne()
            }
        }
    }

    private suspend fun delayValueAndAddOne() {
        delay(2000)
        val number = binding.editTextHome.text.toString().toInt()
        val numberIncreased = number + 1 + counter
        counter++
        binding.textHome.text = numberIncreased.toString()
    }
}
