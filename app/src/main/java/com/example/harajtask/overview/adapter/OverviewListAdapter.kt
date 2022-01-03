package com.example.harajtask.overview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.harajtask.databinding.ItemProductBinding
import com.example.harajtask.models.ProductNetwork

class OverviewListAdapter(private val clickListener: ProductClickListener)
    : ListAdapter<ProductNetwork, ProductViewHolder>(ProductDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder.from(parent,clickListener)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

}

class ProductViewHolder(private val binding: ItemProductBinding, private val clickListener: ProductClickListener)
    : RecyclerView.ViewHolder(binding.root){

        fun bind(product: ProductNetwork){
            binding.product = product
            binding.clickListener = clickListener
        }

    companion object {
        fun from(parent: ViewGroup, clickListener: ProductClickListener): ProductViewHolder{
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemProductBinding.inflate(layoutInflater, parent, false)

            return ProductViewHolder(binding, clickListener)
        }
    }

}

object ProductDiffCallback: DiffUtil.ItemCallback<ProductNetwork>() {
    override fun areItemsTheSame(oldItem: ProductNetwork, newItem: ProductNetwork): Boolean = oldItem == newItem

    override fun areContentsTheSame(oldItem: ProductNetwork, newItem: ProductNetwork): Boolean = oldItem == newItem
}

fun interface ProductClickListener {
    fun onClick(product: ProductNetwork)
}
