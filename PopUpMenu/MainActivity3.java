package com.example.menuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPopUpMenu(view);
            }
        });
    }

    private void openPopUpMenu(View view) {

        PopupMenu menu = new PopupMenu(MainActivity3.this, view);
        menu.getMenuInflater().inflate(R.menu.my_menu, menu.getMenu());

        menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                Toast.makeText(MainActivity3.this, "Clicked on "+ menuItem, Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        menu.show();
    }
}