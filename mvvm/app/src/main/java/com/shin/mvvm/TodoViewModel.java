package com.shin.mvvm;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

/**
 * Created by shin on 21/02/2018.
 */

public class TodoViewModel extends ViewModel{
    private MutableLiveData<Todo> mTodoMutableLiveData;
    private Todo mTodo;

    public LiveData<Todo> getTodo(){
        if (mTodo == null){
            mTodo = new Todo();
            mTodo.setTitle("toto");
        }

        if (mTodoMutableLiveData == null){
            mTodoMutableLiveData = new MutableLiveData<>();
            mTodoMutableLiveData.setValue(mTodo);
        }


        return mTodoMutableLiveData;
    }

    public void setTodo(String input){
        mTodo.setTitle(mTodo.getTitle() +input +"\n");
        mTodoMutableLiveData.setValue(mTodo);
    }

}
