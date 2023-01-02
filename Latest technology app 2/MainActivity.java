package com.example.mygalleryapp2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        ArrayList<DataModel> dataModels = new ArrayList<>();

        dataModels.add(new DataModel(R.drawable.ai, "Artificial Intelligence"));
        dataModels.add(new DataModel(R.drawable.blockchain, "Block Chain"));
        dataModels.add(new DataModel(R.drawable.metaverse, "Meta Verse"));
        dataModels.add(new DataModel(R.drawable.ml, "Machine Learning"));

        MyAdapter adapter = new MyAdapter(dataModels);
        recyclerView.setAdapter(adapter);
    }
}