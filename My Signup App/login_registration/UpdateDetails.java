package com.example.login_registration;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Calendar;

public class UpdateDetails extends AppCompatActivity {

    public static final String KEY1 = "userId";
    private DataBaseHelper myDB;
    private ImageView dob;
    private EditText name, date, mobile, email, userid;
    private Button admin, updateData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_details);

        myDB = new DataBaseHelper(UpdateDetails.this);

        dob = findViewById(R.id.choosedob);
        date = findViewById(R.id.dob);
        name = findViewById(R.id.fullname);
        mobile = findViewById(R.id.mobile);
        email = findViewById(R.id.email);
        userid = findViewById(R.id.userId);

        admin = findViewById(R.id.admin);
        updateData = findViewById(R.id.updateData);

        dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDatePicker();
            }
        });

        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UpdateDetails.this, AdminPage.class);
                intent.putExtra(KEY1, userid.getText().toString());
                startActivity(intent);
            }
        });

        showData();
        updateData();
    }

    public void showData(){
        Intent intent = getIntent();
        String userId = intent.getStringExtra(AdminPage.KEY1);

        Cursor cursor = myDB.getData(userId);

        while(cursor.moveToNext()){
            name.setText(cursor.getString(0));
            date.setText(cursor.getString(1));
            mobile.setText(cursor.getString(2));
            email.setText(cursor.getString(3));
            userid.setText(cursor.getString(5));
        }
    }

    public void updateData(){
        updateData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isUpdated = myDB.updateData(name.getText().toString(), date.getText().toString(), mobile.getText().toString(), email.getText().toString(), userid.getText().toString());

                if(isUpdated){
                    Toast.makeText(UpdateDetails.this, "Data updated successfully!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(UpdateDetails.this, "Oops Something went wrong!", Toast.LENGTH_SHORT).show();
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
                date.setText(i2 + "/" + i1 + "/" + i);
            }
        }, YEAR, MONTH, DATE);
        datePickerDialog.show();
    }


}