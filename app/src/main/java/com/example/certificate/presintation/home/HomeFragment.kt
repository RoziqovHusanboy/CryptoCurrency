package com.example.certificate.presintation.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.appforcertificate.data.model.ConvertData
import com.example.appforcertificate.presintation.home.HomeViewModel

import com.example.certificate.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewmodel by viewModels<HomeViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewmodel.loading.observe(viewLifecycleOwner){
            binding.progress.isVisible = it

        }

        viewmodel.state.observe(viewLifecycleOwner) {
            binding.recyclerview.adapter = ConverterAdapter(it,this::onClick)
        }

    }
    private fun onClick(convertData: ConvertData){
        findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToDetailFragment(convertData.id))
    }


}
