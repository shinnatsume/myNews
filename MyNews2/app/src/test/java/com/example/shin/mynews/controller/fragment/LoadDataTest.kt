package com.example.shin.mynews.controller.fragment

import android.content.Context
import com.example.shin.mynews.BuildConfig
import com.example.shin.mynews.controller.activity.MainActivity
import com.example.shin.mynews.model.Utils.Load
import com.example.shin.mynews.model.Utils.Save
import org.junit.Assert.*
import org.junit.Before

import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.robolectric.Robolectric

import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config


@RunWith(RobolectricTestRunner::class)
@Config(constants = BuildConfig::class)

class LoadDataTest {
    @Mock
    lateinit var mContext : Context

    @Before
    fun setUp(){
        MockitoAnnotations.initMocks(this)
        var activity = Robolectric.buildActivity(MainActivity::class.java).create().resume().get()
        mContext = activity.applicationContext
    }

    @Test
    fun should_load_String(){

        var load = Load(mContext)

        var save  = Save(mContext)

        save.saveString("data","string")

       var dataLoad= load.loadString("string")

        assertEquals(dataLoad, "data")

    }

    @Test
    fun should_load_Int(){
        var load = Load(mContext)

        var save  = Save(mContext)

        save.saveInt(10,"Int")

        var dataLoad= load.loadInt("Int")

        assertEquals(dataLoad, 10)
    }


    @Test
    fun should_load_Boolean(){
        var load = Load(mContext)

        var save  = Save(mContext)

        save.saveBoolean(true,"boolean")

        var dataLoad= load.loadBoolean("boolean")

        assertEquals(dataLoad, true)
    }
}