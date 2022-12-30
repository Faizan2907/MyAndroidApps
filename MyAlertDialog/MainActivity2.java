package com.example.mymusicplayer;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {


    TextView bankName, branchName, balance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        bankName = findViewById(R.id.bank_name);
        branchName = findViewById(R.id.branch);
        balance = findViewById(R.id.balance);

        bankName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bankName.setText("Punjab National");
            }
        });

        branchName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                branchName.setText("Indora, Nagpur");
            }
        });

        balance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity2.this);

                View view1 = LayoutInflater.from(MainActivity2.this).inflate(R.layout.user_access, null);
                alertDialog.setView(view1);

                alertDialog.setMessage("Please fill the following information's");

                alertDialog.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        EditText editText = view1.findViewById(R.id.editText);
                        String pin = editText.getText().toString().trim();
                        if(pin.equals("1999")){
                            balance.setText("1,00,000 INR");
                        }else{
                            Toast.makeText(MainActivity2.this, "Please enter Correct pin", Toast.LENGTH_SHORT).show();
                        }
                    }
                }).setNegativeButton("Cancel", null);

                AlertDialog alert = alertDialog.create();
                alert.show();



                /*alertDialog.setMessage("Are you sure?");

                alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        balance.setText("100000");
                    }
                }).setNegativeButton("No", null);


                AlertDialog alert = alertDialog.create();
                alert.show();*/
            }
        });
    }
}