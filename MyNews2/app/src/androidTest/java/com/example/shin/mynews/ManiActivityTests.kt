package com.example.shin.mynews

import android.app.Fragment
import android.content.Context
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.runner.AndroidJUnit4

import android.support.test.InstrumentationRegistry
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import com.example.shin.mynews.controller.activity.MainActivity
import com.example.shin.mynews.controller.fragment.SearchAndNotificationFragment
import kotlinx.android.synthetic.main.fragment_search_and_notification.*
import org.junit.Before
import org.junit.Test
import org.junit.Rule
import org.junit.runner.RunWith













@RunWith(AndroidJUnit4::class)
@LargeTest
class ManiActivityTests {

    lateinit var mContext : Context
   

    @Rule @JvmField
    val mActivityRule = ActivityTestRule(MainActivity::class.java)

    @Before
    fun setup() {
        mActivityRule.activity.supportFragmentManager.beginTransaction().replace(R.id.activity_main_frame_layout,SearchAndNotificationFragment()).commitAllowingStateLoss()

        this.mContext = InstrumentationRegistry.getTargetContext()


    }

    @Test
    fun isCheckboxChecked(){
        onView(ViewMatchers.withId(R.id.search_edit_text)).perform(typeText("apple"))
        onView(ViewMatchers.withId(R.id.art)).perform(click())
        onView(ViewMatchers.withId(R.id.politics)).perform(click())
        onView(ViewMatchers.withId(R.id.travel)).perform(click())
        onView(ViewMatchers.withId(R.id.entrepreneurs)).perform(click())
        onView(ViewMatchers.withId(R.id.sport)).perform(click())
        onView(ViewMatchers.withId(R.id.business)).perform(click())
        onView(ViewMatchers.withId(R.id.Search_btn)).perform(click())
    }
}