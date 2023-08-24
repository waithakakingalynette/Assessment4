package com.lynn.assessment4

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lynn.assessment4.databinding.RecyclerBinding
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropCircleTransformation

class ItemsAdapter( var itemlist: List<Items>): RecyclerView.Adapter<ItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = RecyclerBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ItemViewHolder( binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentItem = itemlist.get(position)
        val binding = holder.binding
        binding.tvuserId.text= currentItem.title
        binding.tvid.text=currentItem.userId.toString()
        binding.tvtitle.text = currentItem.id.toString()
        binding.tvbody.text= currentItem.body



        Picasso
            .get()
            .load (currentItem.thumbnail)
            .placeholder(R.drawable.ic_launcher_foreground)
            .resize(80,80)
            .centerCrop()
            .transform(CropCircleTransformation())
            .into(binding.imageView)


    }

    override fun getItemCount(): Int {
        return itemlist.size
    }
}
class  ItemViewHolder(var binding: RecyclerBinding): RecyclerView.ViewHolder(binding.root){

}
