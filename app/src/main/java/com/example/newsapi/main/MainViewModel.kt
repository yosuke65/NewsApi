package com.example.newsapi.main

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
    var newsList = MutableLiveData<ArrayList<Article>>()
    fun getObservableArticleList() = newsList
    fun getArticleFromApi(){
        viewModelScope.launch{
            newsList.postValue(repository.getArticleFromApi())
        }
    }
}


class MainViewModelFactory @Inject constructor(private val viewModels: MutableMap<Class<out ViewModel>, Provider<ViewModel>>):ViewModelProvider.Factory{

//    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//        if(modelClass.isAssignableFrom(MainViewModel::class.java)){
//            return viewModels as T
//        }
//        throw IllegalArgumentException("Only MainViewModel class object can be assigned")
//    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T = viewModels[modelClass]?.get() as T

}
