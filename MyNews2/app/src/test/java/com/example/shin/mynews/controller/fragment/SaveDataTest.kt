package com.example.shin.mynews.controller.fragment


import android.content.Context
import com.example.shin.mynews.BuildConfig
import com.example.shin.mynews.controller.activity.MainActivity
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

class SaveDataTest {

@Mock
lateinit var mContext: Context

    @Before
     fun setUp(){
MockitoAnnotations.initMocks(this)
        var activity = Robolectric.buildActivity(MainActivity::class.java).create().resume().get()
        mContext = activity.applicationContext
    }

    @Test
    fun should_save_string(){

        //given
        var save = Save(mContext)
        //when
        var saveData  = save.saveString("data","String")

        val mPreferences = mContext.getSharedPreferences("save",0)
        var dataSaved = mPreferences.getString("String","")
        //then
        assertEquals(dataSaved,"data")

    }


    @Test
    fun should_save_boulean(){
        //given
        var save = Save(mContext)
        //when
        var saveData  = save.saveBoolean(true,"Boolean")

        val mPreferences = mContext.getSharedPreferences("save",0)
        var dataSaved = mPreferences.getBoolean("Boolean",false)
        //then
        assertEquals(dataSaved,true)
    } @Test
    fun should_save_int(){
        //given
        var save = Save(mContext)
        //when
        var saveData  = save.saveInt(10,"Boolean")

        val mPreferences = mContext.getSharedPreferences("save",0)
        var dataSaved = mPreferences.getInt("Boolean",0)
        //then
        assertEquals(dataSaved,10)
    }

}