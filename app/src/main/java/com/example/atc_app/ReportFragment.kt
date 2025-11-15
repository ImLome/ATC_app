package com.example.atc_app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.atc_app.databinding.FragmentReportBinding
import java.util.Date

class ReportFragment : Fragment() {

    private var _binding: FragmentReportBinding? = null
    private val binding get() = _binding!!

    private val reportList = mutableListOf<Report>()
    private lateinit var reportAdapter: ReportAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parentFragmentManager.setFragmentResultListener("new_report_request", this) { _, bundle ->
            val description = bundle.getString("description") ?: ""
            val photoUri = bundle.getString("photo_uri")
            val newReport = Report(description, photoUri, Date())
            reportList.add(0, newReport)
            reportAdapter.notifyItemInserted(0)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentReportBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        reportAdapter = ReportAdapter(reportList)
        binding.reportsRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = reportAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}