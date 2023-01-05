package com.example.bottomsheet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements BottomSheet.BottomSheetListener {

    private Button mButton;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = findViewById(R.id.button);
        mTextView = findViewById(R.id.textView);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomSheet bottomSheet = new BottomSheet();
                bottomSheet.show(getSupportFragmentManager(), bottomSheet.getTag());
            }
        });
    }

    @Override
    public void onClicked(String text) {
        mTextView.setText(text);
    }
}