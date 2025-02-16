package com.example.danhelloworld

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.danhelloworld.databinding.FragmentFirstBinding
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import android.os.Build

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        refreshText()

        binding.refresh.setOnClickListener {
            refreshText()
        }
    }

    fun refreshText(){
        // Show the date, the current android version, and amount of free memory
        val currentDate = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")

        val runtime = Runtime.getRuntime() // used for getting memory stats

        val displayedText = "Hello world!\nThe date and time is ${currentDate.format(formatter)}.\nAndroid version: ${Build.VERSION.RELEASE}\nTotal memory: ${runtime.totalMemory()}\nFree memory:${runtime.freeMemory()}"
        binding.textviewMainContent.text = displayedText
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}