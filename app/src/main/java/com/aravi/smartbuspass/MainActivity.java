package com.aravi.smartbuspass;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity {

    /*DataBaseHelper dataBaseHelper;
    SQLiteDatabase sqLiteDatabase;
    Cursor cursor;*/
    EditText mail,passwd;
    String usrmail,usrpswd;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /* dataBaseHelper=new DataBaseHelper(this);
        sqLiteDatabase=dataBaseHelper.getReadableDatabase();*/
        mail=findViewById(R.id.usrmail);
        passwd=findViewById(R.id.password);
        sharedPreferences=getSharedPreferences("aravnd",MODE_PRIVATE);
    }

    public void register(View view) {
        startActivity(new Intent(this,RegisterActivity.class));
        //finish();
    }

    public void login(View view) {
        usrmail=mail.getText().toString();
        usrpswd=passwd.getText().toString();
        String  em1=sharedPreferences.getString("usrmail","null");
        String ps1=sharedPreferences.getString("usrpswd","null");
        if (usrmail.equals("") && usrpswd.equals("")){
            mail.setError("Please enter Valid E-Mail");
            passwd.setError("Hey Man Why are you Entering wrong Password,Remember!");
        }else if (usrmail.equals("")){
            mail.setError("Please Enter Mail");
        }else if (usrpswd.equals("")){
            passwd.setError("Please Enter Password");
        }
        else if((usrmail.equals(em1))&&(usrpswd.equals(ps1)))
        {
            Toasty.success(this,"Login Success",Toast.LENGTH_SHORT).show();
            //Toast.makeText(this,"Login success",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this,HomeActivity.class));
            mail.setText("");
            passwd.setText("");
        }
        else
        {

            Toasty.error(this, "Plz Enter Valid Details", Toast.LENGTH_SHORT).show();
            mail.setText("");
            passwd.setText("");
        }

       /* cursor=sqLiteDatabase.rawQuery("select * from"+dataBaseHelper.Tablename+"where"+dataBaseHelper.Col_Mail+"=?and"+dataBaseHelper.Col_pswd+"=?",new String[] {usrmail,usrpswd});
        if (cursor==null){
            Toasty.error(this,"Your's Login failed,Enter details");
        }else if (cursor!=null){
            if (cursor.getCount()>0){
                mail.setText("");
                passwd.setText("");
                Toasty.success(this,"You are Login Successfully!",Toast.LENGTH_SHORT).show();
            }else {
                Toasty.error(this,"Please Enter Valid Details",Toast.LENGTH_SHORT).show();
            }
        }*/


    }
}
