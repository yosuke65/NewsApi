package com.example.newsapi

import android.util.Log
import androidx.test.espresso.Espresso
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.newsapi.main.AdapterNewsList
import com.example.newsapi.main.MainActivity
import com.example.newsapi.server.MyMockServer
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    companion object {
        private const val TAG = "MainActivityTest"
    }

    @get: Rule
    val activityRule = activityScenarioRule<MainActivity>()

    private lateinit var mockWebServer: MockWebServer


    @Before
    fun setup() {
        mockWebServer = MockWebServer()
        mockWebServer.start(8080)
    }

    @Test
    fun test_is_list_visible_when_activity_started() {
        mockWebServer.setDispatcher(MyMockServer.SuccessRequestDispatcher())
        Espresso.onView(ViewMatchers.withId(R.id.recyclerview_news))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun test_select_list_item_is_detail_fragment_visible(){
        mockWebServer.setDispatcher(MyMockServer.SuccessRequestDispatcher())
        Espresso.onView(ViewMatchers.withId(R.id.recyclerview_news))
            .perform(RecyclerViewActions.actionOnItemAtPosition<AdapterNewsList.MyViewHolder>(0,ViewActions.click()))
        Espresso.onView(ViewMatchers.withId(R.id.textViewTitle))
            .check(ViewAssertions.matches(ViewMatchers.withText("SaaS Ventures takes the investment road less traveled")))
    }
    @Test
    fun test_back_navigation_to_main_activity(){
        mockWebServer.setDispatcher(MyMockServer.SuccessRequestDispatcher())
        Espresso.onView(ViewMatchers.withId(R.id.recyclerview_news))
            .perform(RecyclerViewActions.actionOnItemAtPosition<AdapterNewsList.MyViewHolder>(1,ViewActions.click()))

        Espresso.onView(ViewMatchers.withId(R.id.textViewTitle))
            .check(ViewAssertions.matches(ViewMatchers.withText("Gaming companies are reportedly the next targets in the US government's Tencent purge")))

        ViewActions.pressBack()

        Espresso.onView(ViewMatchers.withId(R.id.recyclerview_news)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }


    @After
    fun tearDown() {
        Log.d(TAG, "tearDown")
        mockWebServer.shutdown()

    }


}