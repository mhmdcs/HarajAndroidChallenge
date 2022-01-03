package com.example.harajtask.overview

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.harajtask.database.HarajDatabase
import com.example.harajtask.models.Product
import com.example.harajtask.network.HarajApi
import com.example.harajtask.repository.Repository
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class OverviewViewModel(application: Application) : AndroidViewModel(application) {
//    enum class  HarajApiStatus {LOADING, ERROR, SUCCESS}

    private val database = HarajDatabase.getInstance(application)
    private val repo = Repository(database)

    private val _navigateToDetailFragment = MutableLiveData<Product>()
    val navigateToDetailFragment: LiveData<Product>
        get() = _navigateToDetailFragment

    val productList = repo.getCachedProducts

    init {
        viewModelScope.launch {
            repo.refreshProducts()
        }
    }

    fun productClicked(product: Product) {
        _navigateToDetailFragment.value = product
    }

    fun doneNavigation() {
        _navigateToDetailFragment.value = null
    }

}