package com.rku.tutorial7;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;
import android.util.Log;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper
{
    public static final String  DATABASE = "StudentInfo";
    public static final String  TABLE ="student";
    public static final String  COL_1= "id";
    public static final String  COL_2= "first_name";
    public static final String  COL_3= "last_name";
    public static final String  COL_4= "email";
    public static final String  COL_5= "password";
    public static final String  COL_6= "gender";
    public static final String  COL_7= "branch";
    public static final String  COL_8= "city";
    public static final String  COL_9= "profile_status";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE, null, 1);
        SQLiteDatabase db=getWritableDatabase();
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        String sql="CREATE TABLE "+TABLE +"( "+COL_1 +" integer primary key autoincrement, "+COL_2+" text, "+ COL_3+" text, "+COL_4 +" text unique,"+COL_5 +" text, "+COL_6+" text,"+COL_7+" text,"+COL_8+" text,"+COL_9+" text)";
        sqLiteDatabase.execSQL(sql);
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }



    public boolean InsertData(String FirstName,String LastName,String email,String password,String Gender,String Branch,String City,String Status)
    {
        SQLiteDatabase db=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(COL_2,FirstName);
        values.put(COL_3,LastName);
        values.put(COL_4,email);
        values.put(COL_5,password);
        values.put(COL_6,Gender);
        values.put(COL_7,Branch);
        values.put(COL_8,City);
        values.put(COL_9,Status);

        long result=db.insert(TABLE,null,values);

        if(result==-1)
            return false;
        else
            return true;
    }
}

