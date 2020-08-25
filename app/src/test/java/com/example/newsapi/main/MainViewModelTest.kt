package com.example.newsapi.main

import com.example.newsapi.models.Article
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner


@RunWith(value = MockitoJUnitRunner::class)
class MainViewModelTest {
    @Before
    fun setUp() {

    }

    @After
    fun tearDown() {
    }

    @Test
    fun getNewsList() {
    }

    @Test
    fun setNewsList() {
    }

    @Test
    fun getObservableArticleList() {
    }

    @Test
    fun getArticleFromApi() = runBlocking {
        var mainRepository = mock(MainRepository::class.java)
        var viewModel = spy(MainViewModel::class.java)

        var list = ArrayList<Article>()
        list.add(Article("test1","test1","test1",null))
        list.add(Article("test2","test2","test2",null))

        var expectedResults:ArrayList<Article>? = list
        `when`(mainRepository.getArticleFromApi()).thenReturn(expectedResults)
        viewModel.getArticleFromApi()
        val result = viewModel.newsList.value
        assertEquals(result?.size?:0, expectedResults?.size)
    }
}