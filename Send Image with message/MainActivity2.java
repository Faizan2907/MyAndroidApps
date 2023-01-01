package com.example.sendimage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity2 extends AppCompatActivity {

    private ImageView imageView;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        imageView = findViewById(R.id.imageView);
        editText = findViewById(R.id.editTextTextPersonName);

        Intent intent = getIntent();
        String inputMessage = intent.getStringExtra(MainActivity.KEY1);
        int image = intent.getIntExtra(MainActivity.KEY2, 1);

        editText.setText(inputMessage);
        imageView.setImageResource(image);
    }
}