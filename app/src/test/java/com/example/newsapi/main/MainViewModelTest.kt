package com.example.newsapi.main

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.newsapi.models.Article
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain

import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner


@RunWith(value = MockitoJUnitRunner::class)
class MainViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private val testCoroutineDispatcher = TestCoroutineDispatcher()
    @Mock
    private lateinit var mainRepository:MainRepository
    private lateinit var viewModel:MainViewModel

    @Before
    fun setUp() {
        Dispatchers.setMain(testCoroutineDispatcher)
        viewModel = MainViewModel(mainRepository)
    }

    @After
    fun tearDown() {
        testCoroutineDispatcher.cleanupTestCoroutines()
        Dispatchers.resetMain()
    }


    @Test
    fun getArticleFromApi() = runBlocking {

        var expectedResults:ArrayList<Article>? = getDummyData()
        `when`(mainRepository.getArticleFromApi()).thenReturn(expectedResults)
        viewModel.getArticleFromApi()
        val result = viewModel.newsList.value
        assertEquals(result?.size?:0, expectedResults?.size)
    }

    private fun getDummyData(): java.util.ArrayList<Article>? {
        var list = ArrayList<Article>()
        list.add(Article("test1","test1","test1",null))
        list.add(Article("test2","test2","test2",null))
        return list
    }

    @Test
    fun getObservableArticleList() {
        viewModel.newsList.postValue(getDummyData())
        val value = viewModel.newsList.value
        assert(value?.size == 2)
    }
}