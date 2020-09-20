package com.example.newsapi.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.newsapi.models.Article
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

class MainViewModel @Inject constructor(private val repository: MainRepository):ViewModel() {

    companion object{
        private const val TAG = "MainViewModel"
    }
    var newsList = MutableLiveData<ArrayList<Article>>()
    fun getObservableArticleList() = newsList
    fun getArticleFromApi(){
        viewModelScope.launch{
            Log.d(TAG, "getArticleFromApi: ")
            newsList.postValue(repository.getArticleFromApi())
        }
    }
}


class MainViewModelFactory @Inject constructor(private val viewModels: MutableMap<Class<out ViewModel>, Provider<ViewModel>>):ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T = viewModels[modelClass]?.get() as T

}
