package com.example.sendimage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private ImageView imageView;
    private EditText editText;

    public static final String KEY1 = "message";
    public static final String KEY2 = "image";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        imageView = findViewById(R.id.imageView);
        editText = findViewById(R.id.editTextTextPersonName);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = editText.getText().toString();

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra(KEY1, message);
                intent.putExtra(KEY2, R.drawable.faizan);

                startActivity(intent);

                Toast.makeText(MainActivity.this, "Message sent successfully", Toast.LENGTH_SHORT).show();
            }
        });
    }
}