package com.example.letsloginapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.letsloginapp.databinding.ActivityMainBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    String firstName, lastName, mobile, emailId;

    FirebaseDatabase db;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstName = binding.firstname.getText().toString();
                lastName = binding.lastname.getText().toString();
                mobile = binding.mobile.getText().toString();
                emailId = binding.email.getText().toString();

                if(!firstName.isEmpty() && !lastName.isEmpty() && !mobile.isEmpty() && !emailId.isEmpty()){
                    User user = new User(firstName, lastName, mobile, emailId);

                    db = FirebaseDatabase.getInstance();
                    reference = db.getReference("Users");
                    reference.child(firstName).setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            binding.firstname.setText("");
                            binding.lastname.setText("");
                            binding.mobile.setText("");
                            binding.email.setText("");
                            Toast.makeText(MainActivity.this, "Successfully registered.", Toast.LENGTH_SHORT).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(MainActivity.this, "Something went wrong.", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });

        binding.showData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Show_activity.class));
            }
        });
    }
}