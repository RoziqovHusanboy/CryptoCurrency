package com.example.certificate.presintation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.appforcertificate.data.model.ConvertData
import com.example.certificate.R
import com.example.certificate.databinding.ItemRecyclerviewBinding

class ConverterAdapter(
    private val list: List<ConvertData>,
    val onClick:(convertdata:ConvertData)->Unit
) : RecyclerView.Adapter<ConverterAdapter.VH>() {

    inner class VH(private val binding: ItemRecyclerviewBinding) :RecyclerView.ViewHolder(binding.root) {
        fun bind(convertData: ConvertData) = with(binding) {
            code.text = convertData.code
            titleUS.text = convertData.ccy
            titleUZ.text = convertData.ccyNmUZ
            rate.text = convertData.rate
            date.text= root.context.getString(R.string.item_recyclerview_date,convertData.date)
            binding.root.setOnClickListener {
                onClick(convertData)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = VH(
            ItemRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(list[position])
    }

}