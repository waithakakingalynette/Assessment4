package com.lynn.assessment4.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lynn.assessment4.model.Items
import com.lynn.assessment4.repository.ItemRepo
import kotlinx.coroutines.launch
import retrofit2.Response

class ItemsViewModel : ViewModel() {
    private val itemRepo = ItemRepo()
    val itemLiveData = MutableLiveData<List<Items>>()
    val errorLiveData = MutableLiveData<String>()

    fun fetchItems() {
        viewModelScope.launch {
            try {
                val response: Response<List<Items>> = itemRepo.getItems()
                if (response.isSuccessful) {
                    val postsList = response.body() ?: emptyList()
                    itemLiveData.postValue(postsList)
                } else {
                    errorLiveData.postValue(response.errorBody()?.string())
                }
            } catch (e: Exception) {
                errorLiveData.postValue(e.message)
            }
        }
    }
}
