package com.aravi.smartbuspass;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;

import es.dmoral.toasty.Toasty;

public class RegisterActivity extends AppCompatActivity {

    DataBaseHelper dataBaseHelper;
    EditText name, er_mail, mobile, pswd, cpswd;
    String username, usermail, mobilenum, usrpswd, usrcpwd;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Button button;
    AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        dataBaseHelper=new DataBaseHelper(this);
        name = findViewById(R.id.rname);
        er_mail = findViewById(R.id.rmail);
        mobile = findViewById(R.id.rmob);
        pswd = findViewById(R.id.rpass);
        cpswd = findViewById(R.id.rcpass);
        button = findViewById(R.id.registrbtn);

        sharedPreferences = getSharedPreferences("aravnd", MODE_PRIVATE);
        awesomeValidation=new AwesomeValidation(ValidationStyle.BASIC);
        String regexPassword = "(?=.*[a-z])(?=.*[A-Z])(?=.*[\\d])(?=.*[~`!@#\\$%\\^&\\*\\(\\)\\-_\\+=\\{\\}\\[\\]\\|\\;:\"<>,./\\?]).{8,}";
        awesomeValidation.addValidation(this,R.id.rname,"[a-zA-Z\\s]+",R.string.Usrname_error);
        awesomeValidation.addValidation(this,R.id.rmail, android.util.Patterns.EMAIL_ADDRESS,R.string.Email_error);
        awesomeValidation.addValidation(this,R.id.rmob, "^([9]{1})([234789]{1})([0-9]{8})$",R.string.Mbnum_error);
        awesomeValidation.addValidation(this,R.id.rpass, regexPassword,R.string.Password_error);
        awesomeValidation.addValidation(this,R.id.rcpass, R.id.rpass,R.string.ConfirmPassword_error);

    }

    public void onregister(View view) {
        if (awesomeValidation.validate()) {
            username = name.getText().toString();
            usermail = er_mail.getText().toString();
            mobilenum = mobile.getText().toString();
            usrpswd = pswd.getText().toString();
            usrcpwd = cpswd.getText().toString();
            editor=sharedPreferences.edit();
            editor.putString("usrname",username);
            editor.putString("usrmail",usermail);
            editor.putString("usrmmob",mobilenum);
            editor.putString("usrpswd",usrpswd);
            editor.putString("cnfrmpswd",usrcpwd);
            editor.commit();
            Toasty.success(getApplicationContext(),"You Are Registered Successfully",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this,HomeActivity.class);
            intent.putExtra("name",username);
            startActivity(intent);

            //these below code is applied after u pressed register it will erase all fileds in the register form

            name.setText("");
            er_mail.setText("");
            mobile.setText("");
            pswd.setText("");
            cpswd.setText("");
            startActivity(new Intent(this,MainActivity.class));
        }
        else {
            Toasty.error(this,"Registration failed",Toast.LENGTH_SHORT).show();
        }

            /*boolean isInserted=dataBaseHelper.insertuserdata(username,usermail,mobilenum,usrpswd);

            if (isInserted==true) {
                name.setText("");
                er_mail.setText("");
                mobile.setText("");
                pswd.setText("");
                cpswd.setText("");
                Toasty.success(this, "You are registered successfully", Toast.LENGTH_SHORT).show();
            } else {
                Toasty.error(this, "Registration Failed");
            }
        }*/



   /* if (n.equals("")|| em.equals("")|| mb.equals("")|| pwd.equals("")|| cpwd.equals("")){
        Toasty.error(getApplicationContext(),"All Fields Must be Entered",Toast.LENGTH_SHORT).show();
    }  else if (pwd.equals(cpwd)){


    }
    else {
        Toasty.error(getApplicationContext(),"Password And Confirm Pasword Should be The Same",Toast.LENGTH_SHORT).show();
        pswd.setText("");
        cpswd.setText("");
    }*/
    }


}
