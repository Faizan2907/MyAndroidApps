package com.example.mydata;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private DatabaseHelper myDB;
    private EditText userID, userName, userMobile;
    private Button buttonAdd, showButton, updateButton, deleteButton, showAllButton, deleteAllData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDB = new DatabaseHelper(MainActivity.this);

        userID = findViewById(R.id.user_id);
        userName = findViewById(R.id.user_name);
        userMobile = findViewById(R.id.mobile);

        buttonAdd = findViewById(R.id.addButton);
        showButton = findViewById(R.id.showButton);
        updateButton = findViewById(R.id.updateButton);
        deleteButton = findViewById(R.id.deleteButton);
        showAllButton = findViewById(R.id.showAllButton);
        deleteAllData = findViewById(R.id.deleteAllButton);

        addData();
        showData();
        updateData();
        deleteData();
        showAllData();
        deleteAllData();
    }

    public void addData(){
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isInserted = false;
                String user = userName.getText().toString();
                String mobile = userMobile.getText().toString();

                if(!user.isEmpty() || !mobile.isEmpty()){
                    isInserted = myDB.insertData(userName.getText().toString(), userMobile.getText().toString());
                }

                if(isInserted){
                    Toast.makeText(MainActivity.this, "Data inserted successfully!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Something went wrong!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void showData(){
        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = userID.getText().toString();

                if(id.equals(String.valueOf(""))){
                    userID.setError("Please enter ID");
                    return;
                }
                Cursor cursor = myDB.getData(id);
                String data = null;

                if(cursor.moveToNext()){
                    data = "ID : "+cursor.getString(0) + "\n"+
                            "NAME : "+cursor.getString(1)+"\n"+
                            "MOBILE : "+cursor.getString(2)+"\n";
                }

                showMessage("DATA", data);
            }
        });
    }

    public void updateData(){
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isUpdated = myDB.updateData(userID.getText().toString(), userName.getText().toString(), userMobile.getText().toString());
                if(isUpdated){
                    Toast.makeText(MainActivity.this, "Data updated successfully!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Oops Something went wrong!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void deleteData(){
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = userID.getText().toString();
                if(id.equals(String.valueOf(""))){
                    userID.setError("User ID is must");
                }
                Integer var = myDB.deleteData(id);

                if(var > 0){
                    Toast.makeText(MainActivity.this, "Data deleted successfully!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Oops something went wrong!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void showAllData(){
        showAllButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cursor = myDB.getAllData();
                StringBuffer buffer = new StringBuffer();
                if(cursor.getCount() == 0){
                    showMessage("Data", "Nothing found");
                    return;
                }

                while(cursor.moveToNext()){
                    buffer.append("ID : " + cursor.getString(0) + "\n");
                    buffer.append("NAME : " + cursor.getString(1) + "\n");
                    buffer.append("MOBILE : " + cursor.getString(2) + "\n\n");
                }

                showMessage("Data", buffer.toString());
            }
        });
    }

    public void deleteAllData(){
        deleteAllData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer var = myDB.deleteAllData();
                if(var > 0){
                    Toast.makeText(MainActivity.this, "All data deleted successfully!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Oops something went wrong!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void showMessage(String title, String msg){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.create();
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(msg);
        builder.show();
    }
}