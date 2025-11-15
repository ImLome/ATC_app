package com.example.atc_app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.atc_app.databinding.FragmentSignatureBinding

class SignatureFragment : Fragment() {

    private var _binding: FragmentSignatureBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignatureBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.clearButton.setOnClickListener {
            binding.signatureView.clear()
        }

        binding.saveSignatureButton.setOnClickListener {
            val signatureBitmap = binding.signatureView.getSignatureBitmap()
            // In a real app, you would save this bitmap to a file and store the path.
            // For this prototype, we'll just show a confirmation message.
            Toast.makeText(requireContext(), "Firma guardada (prototipo)", Toast.LENGTH_SHORT).show()
            binding.signatureView.clear() // Optionally clear after saving
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}