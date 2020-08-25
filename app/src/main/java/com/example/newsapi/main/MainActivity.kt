package com.example.newsapi.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapi.R
import com.example.newsapi.models.Article
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    companion object{
        private const val TAG = "MainActivity"
    }

    private lateinit var viewModel:MainViewModel
//    @Inject
//    lateinit var mainRepository: MainRepository

    @Inject
    lateinit var mAdapter: AdapterNewsList

    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {

//        //Injection
//        val baseApplication = application as BaseApplication
//        baseApplication.getAppComponent().inject(this)

        //ViewModel
        viewModel = ViewModelProvider(this,mainViewModelFactory).get(MainViewModel::class.java)

        //Recycler view
        recyclerview_news.layoutManager = LinearLayoutManager(this)
        recyclerview_news.adapter = mAdapter

        observe()

        viewModel.getArticleFromApi()

    }

    private fun observe() {
        viewModel.getObservableArticleList().observe(this,Observer<ArrayList<Article>>{
            if(it != null){
                Toast.makeText(this, it.size.toString(), Toast.LENGTH_SHORT).show()
                mAdapter.setData(it)
            }else{
                Toast.makeText(this, "Load Failed", Toast.LENGTH_SHORT).show()
            }
        })
    }
}