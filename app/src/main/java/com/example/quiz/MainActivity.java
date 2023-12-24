package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    MainActivity binding;
    RecyclerView recyclerView;
    QuizAdapater adapater;

    Toolbar toolbar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        List<Quiz> question = new ArrayList<>();
        question.add(new Quiz("1","Android is - ?", Arrays.asList("Os","web browser","web server","Cloud")));
        question.add(new Quiz("2","For which of the following Android is mainly developed?",Arrays.asList("Server ","Desktop ","Laptop ","Mobile devices")));
        question.add(new Quiz("3","Which of the following kernel is used in Android? ?",Arrays.asList("MAC","Windows","Linux","Redhat")));
        question.add(new Quiz("4","Which of the following is not an activity lifecycle callback method?",Arrays.asList("onClick()","onCreate()","onStart()","onBackPressed()")));




        recyclerView = findViewById(R.id.recyclerview);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        adapater = new QuizAdapater(question,MainActivity.this);
        recyclerView.setAdapter(adapater);
        recyclerView.setLayoutManager(layoutManager);




    }
}