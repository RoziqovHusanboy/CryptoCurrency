package com.example.certificate.presintation.splash_sceen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.certificate.R
import com.example.certificate.databinding.FragmentSplashBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment:Fragment() {
    lateinit var binding:FragmentSplashBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSplashBinding.inflate(inflater)
        return  binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val anim  = AnimationUtils.loadAnimation(requireContext(),R.anim.scale_anim)
        binding.logo.startAnimation(anim)
        val alpha  = AnimationUtils.loadAnimation(requireContext(),R.anim.alpha_anim)
        binding.title.startAnimation(alpha)
        val translate  = AnimationUtils.loadAnimation(requireContext(),R.anim.translate_anim)
        binding.next.startAnimation(translate)

        binding.next.setOnClickListener {
            findNavController().navigate(SplashFragmentDirections.toHomeFragment())
        }
    }
}