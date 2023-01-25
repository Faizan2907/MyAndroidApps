package com.example.letsloginapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.letsloginapp.databinding.ActivityMainBinding;
import com.example.letsloginapp.databinding.ActivityShowBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Show_activity extends AppCompatActivity {

    ActivityShowBinding binding;
    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference reference = db.getReference().child("Users");
    private MyAdapter adapter;
    private ArrayList<User> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        binding = ActivityShowBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mList = new ArrayList<>();
        adapter = new MyAdapter(this, mList);

        binding.recyclerView.setAdapter(adapter);

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    User user = dataSnapshot.getValue(User.class);
                    mList.add(user);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}