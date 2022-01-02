package com.example.harajtask.overview.adapter

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.harajtask.R
import com.example.harajtask.models.Product

@BindingAdapter("productImage")
fun fetchImage(imgView: ImageView, imgSrc: String?){
    imgSrc?.let {
        val uri = imgSrc.toUri().buildUpon().scheme("https").build()

        Glide.with(imgView.context).load(uri)
            .placeholder(R.drawable.loading_animation)
            .error(R.drawable.ic_broken_image)
            .transform(RoundedCorners(4)).into(imgView)
    }
}

@BindingAdapter("productsList")
fun bindRecyclerView(recyclerView: RecyclerView, productsList: List<Product>?){
    val adapter = recyclerView.adapter as OverviewListAdapter
    adapter.submitlist(productsList)
}