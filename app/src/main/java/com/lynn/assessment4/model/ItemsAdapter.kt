package com.lynn.assessment4.model

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lynn.assessment4.databinding.RecyclerBinding

class ItemsAdapter(var items: List<Items>): RecyclerView.Adapter<ItemViewHolder>() {
    lateinit var binding: RecyclerBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = RecyclerBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ItemViewHolder( binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentItem = items.get(position)
        val binding = holder.binding
        binding.tvuserId.text= currentItem.title
        binding.tvid.text=currentItem.userId.toString()
        binding.tvtitle.text = currentItem.id.toString()
        binding.tvbody.text= currentItem.body




    }

    override fun getItemCount(): Int {
        return items.size
    }
}
class  ItemViewHolder(var binding: RecyclerBinding): RecyclerView.ViewHolder(binding.root){

}