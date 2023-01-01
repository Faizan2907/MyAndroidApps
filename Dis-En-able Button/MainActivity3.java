package com.example.sendimage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    private EditText editText, password;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        editText = findViewById(R.id.username);
        password = findViewById(R.id.password);
        button = findViewById(R.id.button2);

        editText.addTextChangedListener(textWatcher);
        password.addTextChangedListener(textWatcher);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = editText.getText().toString();
                String pass = password.getText().toString();

                if(user.equals("Faizan2907") && pass.equals("2023")){
                    Intent intent = new Intent(MainActivity3.this, MainActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(MainActivity3.this, "Please enter correct login credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String username = editText.getText().toString().trim();
            String pass = password.getText().toString().trim();

            button.setEnabled(!username.isEmpty() && !pass.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
}