package com.example.login_registration;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Calendar;

public class SignUp extends AppCompatActivity {

    private DataBaseHelper myDB;
    private ImageView dob;
    private EditText name, date, mobile, email, password, password1, userId;
    private Button signin, signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        myDB = new DataBaseHelper(SignUp.this);

        dob = findViewById(R.id.choosedob);
        date = findViewById(R.id.dob);
        name = findViewById(R.id.fullname);
        mobile = findViewById(R.id.mobile);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        password1 = findViewById(R.id.password1);
        signin = findViewById(R.id.signin);
        signup = findViewById(R.id.signup);
        userId = findViewById(R.id.userId);

        addData();

        dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDatePicker();
            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myIntent();
            }
        });
    }

    public boolean validateEmail(){
        String emailInput = email.getText().toString().trim();

        if(emailInput.isEmpty()){
            email.setError("Field can't be empty");
            return false;
        }
        else{
            email.setError(null);
            return true;
        }
    }

    private boolean validateUSerId(){
        String userId1 = userId.getText().toString().trim();

        if(userId1.isEmpty()){
            userId.setError("Field can't be empty");
            return false;
        }
        else if(userId1.length()>=10){
            userId.setError("User name too long");
            return false;
        }
        else{
            userId.setError(null);
            return true;
        }
    }

    private boolean fullName(){
        String username = name.getText().toString().trim();

        if(username.isEmpty()){
            name.setError("Field can't be empty");
            return false;
        }
        else{
            name.setError(null);
            return true;
        }
    }

    private boolean mobileNumber(){
        String mob = mobile.getText().toString().trim();

        if(mob.isEmpty()){
            mobile.setError("Field can't be empty");
            return false;
        }
        else{
            mobile.setError(null);
            return true;
        }
    }

    private boolean dateOfBirth(){
        String dob = date.getText().toString().trim();

        if(dob.isEmpty()){
            date.setError("Field can't be empty");
            return false;
        }
        else{
            date.setError(null);
            return true;
        }
    }

    private boolean password(){
        String pass = password.getText().toString().trim();
        String pass1 = password1.getText().toString().trim();

        if(pass.isEmpty()){
            password.setError("Field can't be empty");
            return false;
        }
        else if(!pass.equals(pass1)){
            password1.setError("Password is not matching");
            return false;
        }
        else{
            password.setError(null);
            return true;
        }
    }


    public void myIntent(){
        Intent intent = new Intent(SignUp.this, MainActivity.class);
        startActivity(intent);
    }

    public void addData(){
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isInserted = false;
                
                String fullname = name.getText().toString().trim();
                String dataofbirth = date.getText().toString();
                String mob = mobile.getText().toString();
                String email1 = email.getText().toString();
                String pass = password.getText().toString();
                String pass1 = password1.getText().toString();
                String userId1 = userId.getText().toString();

                //if(!fullname.equals(String.valueOf("")) || !dataofbirth.equals(String.valueOf("")) || !mob.equals(String.valueOf("")) || !email1.equals(String.valueOf("")) || pass.equals(String.valueOf("")) || pass1.equals(String.valueOf(""))){
                if(!fullName() | !dateOfBirth() | !validateEmail() | !mobileNumber() | !password() | !validateUSerId()){
                    Toast.makeText(SignUp.this, "Oops something went wrong!", Toast.LENGTH_SHORT).show();
                }
                else{
                    myDB.insertData(fullname, dataofbirth, mob, email1, pass, userId1);
                    Toast.makeText(SignUp.this, "Data Inserted Successfully!", Toast.LENGTH_SHORT).show();
                    myIntent();
                }
            }
        });
    }

    public void openDatePicker() {

        Calendar calendar = Calendar.getInstance();

        int YEAR = calendar.get(Calendar.YEAR);
        int MONTH = calendar.get(Calendar.MONTH);
        int DATE = calendar.get(Calendar.DATE);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                i1++;
                //Date : dd/mm/yyyy
                date.setText(i2 + "/" + i1 + "/" + i);
            }
        }, YEAR, MONTH, DATE);
        datePickerDialog.show();
    }
}
