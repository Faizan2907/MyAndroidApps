package com.example.mymusicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    Spinner spinner, spinner1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        spinner = findViewById(R.id.spinner);
        spinner1 = findViewById(R.id.spinner2);

        String[] lecturer = {"John", "Smith", "Fredy"};
        String[] course = {"Java", "Advance Java"};
        String[] course1 = {"Data Structure", "Advance Algorithm"};
        String[] course2 = {"DBMS", "DC"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, lecturer);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, course);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, course1);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, course2);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        spinner1.setAdapter(adapter1);
                        break;

                    case 1:
                        spinner1.setAdapter(adapter2);
                        break;

                    case 2:
                        spinner1.setAdapter(adapter3);
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}