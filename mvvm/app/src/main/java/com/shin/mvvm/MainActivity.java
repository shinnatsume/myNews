package com.shin.mvvm;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.shin.mvvm.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private TodoViewModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil
                .setContentView(this,R.layout.activity_main);

//        binding.setTitle("hello world !");
        binding.setInput("");
        model = ViewModelProviders.of(this)
                .get(TodoViewModel.class);


        model.getTodo().observe(this,todo -> {
            binding.setTitle(todo.getTitle());
        });
    }

    public void saveTodo(View view) {
        model.setTodo(binding.editText.getText().toString());
    }
}
