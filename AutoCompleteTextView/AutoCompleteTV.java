package com.example.mymusicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.Toast;

public class AutoCompleteTV extends AppCompatActivity {

    private AutoCompleteTextView autoCompleteTextView;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_complete_tv);

        autoCompleteTextView = findViewById(R.id.autoCompleteTextView);
        imageView = findViewById(R.id.imageView);

        String subject[] = {"Java", "Advance Java", "Data Structure", "Advance Algorithm", "DBMS", "DC"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, subject);
        autoCompleteTextView.setAdapter(adapter);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                autoCompleteTextView.showDropDown();
            }
        });

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(AutoCompleteTV.this, "Subject name is : " + subject[i], Toast.LENGTH_SHORT).show();
            }
        });

    }
}