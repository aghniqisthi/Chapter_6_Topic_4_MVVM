package com.example.chapter6topic4mvvp.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.chapter6topic4mvvp.R
import com.example.chapter6topic4mvvp.databinding.ItemCarBinding
import com.example.chapter6topic4mvvp.model.ResponseDataCarItem
import kotlinx.android.synthetic.main.item_car.view.*

class CarAdapter(var listCar : List<ResponseDataCarItem>) : RecyclerView.Adapter<CarAdapter.ViewHolder>() {

    class ViewHolder(var binding: ItemCarBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarAdapter.ViewHolder {
        var view = ItemCarBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CarAdapter.ViewHolder, position: Int) {
        holder.itemView.txtJudulFilm.text = listCar!![position].name
        holder.itemView.txtYearFilm.text = listCar!![position].category
    }

    override fun getItemCount(): Int = listCar!!.size
}