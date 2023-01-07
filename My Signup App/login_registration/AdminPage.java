package com.example.login_registration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AdminPage extends AppCompatActivity {

    public static final String KEY1 = "userId";

    DataBaseHelper myDB;
    private TextView uname, mobile, email, userid, dob;
    private Button signin, updateDetails;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        myDB = new DataBaseHelper(AdminPage.this);

        signin = findViewById(R.id.signin);
        updateDetails = findViewById(R.id.update);

        uname = findViewById(R.id.userFullname);
        dob = findViewById(R.id.dob);
        mobile = findViewById(R.id.mobile);
        email = findViewById(R.id.email);
        userid = findViewById(R.id.userId);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminPage.this, MainActivity.class);
                startActivity(intent);
            }
        });

        updateDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminPage.this, UpdateDetails.class);
                intent.putExtra(KEY1, userid.getText().toString());
                startActivity(intent);
            }
        });

        showData();
    }

    public void showData(){
        Intent intent = getIntent();
        String userId = intent.getStringExtra(MainActivity.KEY1);

        Cursor cursor = myDB.getData(userId);

        while(cursor.moveToNext()){
            uname.setText(cursor.getString(0));
            dob.setText(cursor.getString(1));
            mobile.setText(cursor.getString(2));
            email.setText(cursor.getString(3));
            userid.setText(cursor.getString(5));
        }
    }
}