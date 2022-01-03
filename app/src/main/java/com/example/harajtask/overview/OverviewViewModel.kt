package com.example.harajtask.overview

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.harajtask.database.HarajDatabase
import com.example.harajtask.models.ProductNetwork
import com.example.harajtask.network.HarajApi
import com.example.harajtask.repository.Repository
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class OverviewViewModel(application: Application): AndroidViewModel(application) {
//    enum class  HarajApiStatus {LOADING, ERROR, SUCCESS}

    private val database = HarajDatabase.getInstance(application)
    private val repo = Repository(database)

    private val _products = MutableLiveData<List<ProductNetwork>>()
    val products: LiveData<List<ProductNetwork>>
        get() = _products

    private val _navigateToDetailFragment = MutableLiveData<ProductNetwork>()
    val navigateToDetailFragment: LiveData<ProductNetwork>
        get() = _navigateToDetailFragment

    val productList  = repo.getCachedProducts


    init {
        viewModelScope.launch {
            repo.refreshProducts()
        }
    }


    fun productClicked(product: ProductNetwork){
        _navigateToDetailFragment.value = product
    }

    fun doneNavigation(){
        _navigateToDetailFragment.value = null
    }

}