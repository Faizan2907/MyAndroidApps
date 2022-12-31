package com.example.menuapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview);

        String[] languages = {"Java", "Kotlin", "C", "CPP", "Ruby", "Python", "JS", "C#"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, languages);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(MainActivity.this, "Language is : " + languages[i], Toast.LENGTH_SHORT).show();
                switch (languages[i]){
                    case "Java":
                        intent.putExtra("url", "https://www.javatpoint.com/java-tutorial");
                        startActivity(intent);
                        break;

                    case "Kotlin":
                        intent.putExtra("url", "https://www.javatpoint.com/kotlin-tutorial");
                        startActivity(intent);
                        break;

                    case "C":
                        intent.putExtra("url", "https://www.javatpoint.com/c-programming-language-tutorial");
                        startActivity(intent);
                        break;

                    case "CPP":
                        intent.putExtra("url", "https://www.javatpoint.com/cpp-tutorial");
                        startActivity(intent);
                        break;

                    case "Ruby":
                        intent.putExtra("url", "https://www.javatpoint.com/ruby-tutorial");
                        startActivity(intent);
                        break;

                    case "Python":
                        intent.putExtra("url", "https://www.javatpoint.com/python-tutorial");
                        startActivity(intent);
                        break;

                    case "JS":
                        intent.putExtra("url", "https://www.javatpoint.com/javascript-tutorial");
                        startActivity(intent);
                        break;

                    case "C#":
                        intent.putExtra("url", "https://www.javatpoint.com/c-sharp-tutorial");
                        startActivity(intent);
                        break;

                    default:
                        break;
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = new MenuInflater(this);
        menuInflater.inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Toast.makeText(this, "Selected : " + item, Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }


}