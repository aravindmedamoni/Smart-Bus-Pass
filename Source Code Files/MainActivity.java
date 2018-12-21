package com.aruns.smartapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    EditText memail,mpass;
    String em,ps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        memail=findViewById(R.id.usrmail);
        mpass=findViewById(R.id.password);
        sharedPreferences=getSharedPreferences("arun",MODE_PRIVATE);
    }

    public void register(View view) {
        startActivity(new Intent(this,RegisterForm.class));
        //finish();
    }

    public void login(View view) {
        em=memail.getText().toString();
        ps=mpass.getText().toString();

      String  em1=sharedPreferences.getString("usrmail","null");
       String ps1=sharedPreferences.getString("usrpswd","null");
     if((em.equals(em1))&&(ps.equals(ps1)))
     {
         Toast.makeText(this,"Login success",Toast.LENGTH_SHORT).show();
         startActivity(new Intent(this,Home.class));
     }
     else
     {
         Toast.makeText(this, "plz enter valid details", Toast.LENGTH_SHORT).show();
     }
    }
}
