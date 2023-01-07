package com.example.login_registration;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "COMPANY_DATA";
    private static final String TABLE_NAME = "USER_DETAILS";
    private static final String COL_1 = "FULLNAME";
    private static final String COL_2 = "DOB";
    private static final String COL_3 = "MOBILE";
    private static final String COL_4 = "EMAIL";
    private static final String COL_5 = "PASSWORD";
    private static final String COL_6 = "USERID";


    public DataBaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME+"(FULLNAME TEXT, DOB NUMBER, MOBILE TEXT, EMAIL TEXT, PASSWORD TEXT, USERID TEXT PRIMARY KEY)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public boolean insertData(String name, String dob, String mobile, String email, String password, String userid){
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COL_1, name);
        values.put(COL_2, dob);
        values.put(COL_3, mobile);
        values.put(COL_4, email);
        values.put(COL_5, password);
        values.put(COL_6, userid);

        long var = db.insert(TABLE_NAME, null, values);

        if(var == -1){
            return false;
        }
        else{
            return true;
        }
    }

    public Cursor getData(String userId){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM "+TABLE_NAME+" WHERE USERID='"+userId+"'";

        Cursor cursor = db.rawQuery(query, null);

        return cursor;
    }

    public boolean updateData(String username, String dob, String mobile, String email, String userId){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_1, username);
        values.put(COL_2, dob);
        values.put(COL_3, mobile);
        values.put(COL_4, email);
        values.put(COL_6, userId);

        db.update(TABLE_NAME, values, "USERID=?", new String[]{userId});
        return true;
    }
}
