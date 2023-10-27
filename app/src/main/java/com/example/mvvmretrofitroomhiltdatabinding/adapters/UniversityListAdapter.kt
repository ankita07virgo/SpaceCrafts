package com.example.mvvmretrofitroomhiltdatabinding.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmretrofitroomhiltdatabinding.databinding.UniversityitemBinding
import com.example.mvvmretrofitroomhiltdatabinding.modal.University

class UniversityListAdapter(private val onRecyclerViewItemClick: (University) -> Unit) : RecyclerView.Adapter<MainViewHolder>() {
    private var universityList = mutableListOf<University>()

    fun setUniversity(universityList : List<University>){
        this.universityList.clear()
        this.universityList.addAll(universityList)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val infalter = LayoutInflater.from(parent.context)
        val binding = UniversityitemBinding.inflate(infalter,parent,false)
        return MainViewHolder(binding)
    }

    override fun getItemCount(): Int {
       return  universityList.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val universityItem = universityList[position]
        holder.binding.name.text = universityItem.name
        holder.binding.cardview.setOnClickListener {
            onRecyclerViewItemClick(universityItem)
        }
    }
}

class MainViewHolder(val binding: UniversityitemBinding) : RecyclerView.ViewHolder(binding.root){

}
