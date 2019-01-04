package com.aravi.smartbuspass;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="Register.db";
    public static final String Tablename="RegistrationForm";
    public static final String Col_id="Id";
    public static final String Col_name="Username";
    public static final String Col_Mail="UserE_mail";
    public static final String Col_mblnum="Mobile_number";
    public static final String Col_pswd="Password";
    public static final int version=1;
    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+Tablename+"(Id integer primary key autoincrement,Username text,userE_mail text,Mobile_number number,Password text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("drop table if exists "+Tablename);
        onCreate(db);

    }
    public boolean insertuserdata(String Username,String UserE_mail,String Mobile_number,String Password)
    {
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(Col_name,Username);
        contentValues.put(Col_Mail,UserE_mail);
        contentValues.put(Col_mblnum,Mobile_number);
        contentValues.put(Col_pswd,Password);
        long result=sqLiteDatabase.insert(Tablename,null,contentValues);
        if (result==-1)
            return false;
        else
            return true;
    }
}
