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

    private AutoCompleteTextView autoCompleteTextView, autoCompleteTextView1;
    private ImageView imageView, imageView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_complete_tv);

        autoCompleteTextView = findViewById(R.id.autoCompleteTextView);
        autoCompleteTextView1 = findViewById(R.id.autoCompleteTextView1);
        imageView = findViewById(R.id.imageView);
        imageView1 = findViewById(R.id.imageView1);

        String[] states = {"Maharashtra", "Delhi", "Telangana"};
        String[] mh_Cities = {"Nagpur", "Nanded", "Mumbai", "Pune"};
        String[] de_Cities = {"New Delhi", "Nizamabad", "Sangli", "Ahemadnagar"};
        String[] tl_Cities = {"Hydrabad", "Nizampur", "Vishaka", "Andheri"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, states);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, mh_Cities);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, de_Cities);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, tl_Cities);


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
                switch (i){
                    case 0:
                        autoCompleteTextView1.setAdapter(adapter1);
                        imageView1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                autoCompleteTextView1.showDropDown();
                            }
                        });
                        autoCompleteTextView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                Toast.makeText(AutoCompleteTV.this, "City : " + mh_Cities[i] + " belongs to State" + states[0], Toast.LENGTH_SHORT).show();
                            }
                        });
                        break;

                    case 1:
                        autoCompleteTextView1.setAdapter(adapter2);
                        imageView1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                autoCompleteTextView1.showDropDown();
                            }
                        });
                        autoCompleteTextView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                Toast.makeText(AutoCompleteTV.this, "City : " + de_Cities[i] + " belongs to State" + states[1], Toast.LENGTH_SHORT).show();
                            }
                        });
                        break;

                    case 2:
                        autoCompleteTextView1.setAdapter(adapter3);
                        imageView1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                autoCompleteTextView1.showDropDown();
                            }
                        });
                        autoCompleteTextView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                Toast.makeText(AutoCompleteTV.this, "City : " + tl_Cities[i] + " belongs to State" + states[2], Toast.LENGTH_SHORT).show();
                            }
                        });
                        break;
                }
            }
        });


        /*String subject[] = {"Java", "Advance Java", "Data Structure", "Advance Algorithm", "DBMS", "DC"};
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
        });*/

    }
}
