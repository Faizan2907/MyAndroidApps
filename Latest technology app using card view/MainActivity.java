package com.example.mygalleryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ListView nlistView;
    private String [] names = {"Machine Learning", "Artificial Intelligence", "Meta-verse", "Block chain"};
    private int [] images = {R.drawable.ml, R.drawable.ai, R.drawable.metaverse, R.drawable.blockchain};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nlistView = findViewById(R.id.listView);

        MyAdapter adapter = new MyAdapter();
        nlistView.setAdapter(adapter);


    }

    public class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            view = getLayoutInflater().inflate(R.layout.card, viewGroup, false);
            ImageView nimageView = view.findViewById(R.id.imageView);
            TextView ntextView = view.findViewById(R.id.textView);

            ntextView.setText(names[i]);
            nimageView.setImageResource(images[i]);

            actionPerform(ntextView);

            return view;
        }

        private void actionPerform(TextView ntextView) {

            ntextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    String check = ntextView.getText().toString();
                    switch (check){
                        case "Machine Learning":
                            intent.putExtra("url", "https://www.geeksforgeeks.org/machine-learning/");
                            startActivity(intent);
                            break;

                        case "Artificial Intelligence":
                            intent.putExtra("url", "https://www.geeksforgeeks.org/artificial-intelligence-an-introduction/");
                            startActivity(intent);
                            break;

                        case "Meta-verse":
                            intent.putExtra("url", "https://www.geeksforgeeks.org/what-is-metaverse/");
                            startActivity(intent);
                            break;

                        case "Block chain":
                            intent.putExtra("url", "https://www.geeksforgeeks.org/blockchain-technology-introduction/");
                            startActivity(intent);
                            break;

                        default:
                            break;
                    }
                }
            });

        }
    }
}