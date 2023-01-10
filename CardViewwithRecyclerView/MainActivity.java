package com.example.cardviewwithrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<String> titles;
    private List<Integer> mImages;

    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recyclerView);

        titles = new ArrayList<>();
        mImages = new ArrayList<>();

        myAdapter = new MyAdapter(this, titles, mImages);

        mImages.add(R.drawable.c);
        mImages.add(R.drawable.cpp);
        mImages.add(R.drawable.java);
        mImages.add(R.drawable.css);
        mImages.add(R.drawable.csharp);
        mImages.add(R.drawable.angular);
        mImages.add(R.drawable.html);
        mImages.add(R.drawable.c);
        mImages.add(R.drawable.cpp);
        mImages.add(R.drawable.java);
        mImages.add(R.drawable.css);
        mImages.add(R.drawable.csharp);
        mImages.add(R.drawable.angular);
        mImages.add(R.drawable.html);


        titles.add("C Programming");
        titles.add("C++ Programming");
        titles.add("Java Programming");
        titles.add("Cascading Style Sheets");
        titles.add("C Sharp Programming");
        titles.add("Angular Programming");
        titles.add("HTML");
        titles.add("C Programming");
        titles.add("C++ Programming");
        titles.add("Java Programming");
        titles.add("Cascading Style Sheets");
        titles.add("C Sharp Programming");
        titles.add("Angular Programming");
        titles.add("HTML");

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);

        mRecyclerView.setLayoutManager(gridLayoutManager);
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setAdapter(myAdapter);
    }
}
