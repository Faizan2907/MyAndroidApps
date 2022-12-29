package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

//    RadioButton male, female;
//    RadioGroup rg;

    EditText text1, text2;
    Button button, button2;
    CheckBox cbox;

    public static  final String msg = "Hey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        setContentView(R.layout.radio_button_example);

//        button2 = findViewById(R.id.button2);
//        male = findViewById(R.id.male);
//        female = findViewById(R.id.female);
//        rg = findViewById(R.id.radioGroup);

        text1 = findViewById(R.id.editText1);
        text2 = findViewById(R.id.editText2);
        button = findViewById(R.id.button);
        cbox = findViewById(R.id.checkBox);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cbox.isChecked()){
                    Integer num1 = Integer.parseInt(text1.getText().toString());
                    Integer num2 = Integer.parseInt(text2.getText().toString());
                    Integer sum = num1 + num2;

                    Intent intent = new Intent(MainActivity.this, MainActivity3.class);
                    intent.putExtra(msg, sum.toString());
                    startActivity(intent);
                }
                else{
                    Toast.makeText(MainActivity.this, "Plase click on the check box", Toast.LENGTH_SHORT).show();
                }
                //Toast.makeText(MainActivity.this, "Addition : " + sum, Toast.LENGTH_SHORT).show();
            }
        });

//        button2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                int id = rg.getCheckedRadioButtonId();
//                RadioButton rb = findViewById(id);
//
//                Toast.makeText(MainActivity.this, "Clicked " + rb.getText().toString(), Toast.LENGTH_SHORT).show();
//            }
//        });
    }
}