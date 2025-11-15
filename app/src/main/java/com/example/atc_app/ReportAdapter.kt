package com.example.atc_app

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.atc_app.databinding.ItemReportBinding
import java.text.SimpleDateFormat
import java.util.Locale

class ReportAdapter(private val reports: List<Report>) : RecyclerView.Adapter<ReportAdapter.ReportViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReportViewHolder {
        val binding = ItemReportBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ReportViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ReportViewHolder, position: Int) {
        holder.bind(reports[position])
    }

    override fun getItemCount() = reports.size

    inner class ReportViewHolder(private val binding: ItemReportBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(report: Report) {
            binding.reportDescription.text = report.description
            val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault())
            binding.reportDate.text = sdf.format(report.date)
            if (report.photoUri != null) {
                binding.reportImage.setImageURI(android.net.Uri.parse(report.photoUri))
            } else {
                binding.reportImage.setImageResource(android.R.drawable.ic_menu_camera)
            }
        }
    }
}