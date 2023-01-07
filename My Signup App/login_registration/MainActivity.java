package com.example.login_registration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String KEY1 = "userId";
    DataBaseHelper myDB;
    private Button signinButton, signupButton;
    private EditText userid, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDB = new DataBaseHelper(MainActivity.this);

        signinButton = findViewById(R.id.signin);
        signupButton = findViewById(R.id.signup);

        userid = findViewById(R.id.userId);
        password = findViewById(R.id.password);

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SignUp.class);
                startActivity(intent);
            }
        });

        showData();
    }

    public void showData(){
        signinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userId = userid.getText().toString();
                String password1 = password.getText().toString();
                if(userId.equals(String.valueOf(""))){
                    userid.setError("Field should not be empty");
                }
                else if(password1.equals(String.valueOf(""))){
                    password.setError("Field should not be empty");
                }

                Cursor cursor = myDB.getData(userId);
                while(cursor.moveToNext()){
                    if(cursor.getString(5).equals(userId) & cursor.getString(4).equals(password1)){
                        //Toast.makeText(MainActivity.this, "Authorized user!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, AdminPage.class);
                        intent.putExtra(KEY1, cursor.getString(5));

                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Unauthorized user!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}