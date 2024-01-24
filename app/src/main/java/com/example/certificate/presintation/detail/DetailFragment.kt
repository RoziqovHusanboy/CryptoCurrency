package com.example.certificate.presintation.detail

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.certificate.R
import com.example.certificate.databinding.DetailFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {
    private lateinit var binding: DetailFragmentBinding
    private val args by navArgs<DetailFragmentArgs>()
    private val viewModel by viewModels<DetailViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DetailFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.setDetail(args.id)
        viewModel.detail.observe(viewLifecycleOwner) {
            it.forEach { data ->
                if (data.id == args.id) {
                    binding.countFirst.text = data.ccy
                    binding.inputText.text = binding.root.context.getString(
                        R.string.detail_fragment_rate, data.ccy, data.rate
                    )

                    val counfirst = binding.countFirstET
                    counfirst.addTextChangedListener(object : TextWatcher {
                        override fun beforeTextChanged(
                            s: CharSequence?,
                            start: Int,
                            count: Int,
                            after: Int
                        ) {}

                        override fun onTextChanged(
                            s: CharSequence?,
                            start: Int,
                            before: Int,
                            count: Int
                        ) {}

                        override fun afterTextChanged(s: Editable?) {
                            try {
                                val text = s.toString()
                                val number = text.toInt()
                                val rate: Int = data.rate.toDouble().toInt()
                                val result = number * rate
                                binding.countSecondET.text = result.toString()
                            } catch (e: Exception) {
                                binding.countSecondET.text = e.toString()
                            }

                        }

                    })
                }
            }

        }

    }
}

