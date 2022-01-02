package com.example.harajtask.overview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.harajtask.databinding.ItemProductBinding
import com.example.harajtask.models.Product

class OverviewListAdapter(private val clickListener: ProductClickListener)
    : ListAdapter<Product, ProductViewHolder>(ProductDiffCallback) {

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

        fun bind(product: Product){
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

object ProductDiffCallback: DiffUtil.ItemCallback<Product>() {
    override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean = oldItem == newItem
}

fun interface ProductClickListener {
    fun onClick(product: Product)
}
