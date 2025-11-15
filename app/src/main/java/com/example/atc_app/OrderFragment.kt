package com.example.atc_app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.atc_app.databinding.FragmentOrderBinding

class OrderFragment : Fragment() {

    private var _binding: FragmentOrderBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOrderBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnStartTrip.setOnClickListener {
            binding.deliveryStatus.text = "En Ruta"
        }

        binding.btnArriveDestination.setOnClickListener {
            binding.deliveryStatus.text = "En Destino"
        }

        binding.btnCompleteDelivery.setOnClickListener {
            binding.deliveryStatus.text = "Entrega Finalizada"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}