package com.aruns.smartapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterForm extends AppCompatActivity {
EditText name,mail,mob,pass,cpass;
String n,e,m,p,cp;
//Button reg;
SharedPreferences sp;
SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_form);
        name=findViewById(R.id.rname);
        mail=findViewById(R.id.rmail);
        mob=findViewById(R.id.rmob);
        pass=findViewById(R.id.rpass);
        cpass=findViewById(R.id.rcpass);
        sp=getSharedPreferences("arun",MODE_PRIVATE);

    }

    public void onreg(View view) {
        n=name.getText().toString();
        e=mail.getText().toString();
        m=mob.getText().toString();
        p=pass.getText().toString();
        cp=cpass.getText().toString();

        if ((n.equals(""))|| (e.equals(""))||(m.equals(""))||(p.equals("")))
        {
            Toast.makeText(this, "All fields are required!!", Toast.LENGTH_SHORT).show();
        }
        else if(p.equals(cp))
        {
            editor=sp.edit();
            editor.putString("usrname",n);
            editor.putString("usrmail",e);
            editor.putString("usrmob",m);
            editor.putString("usrpswd",p);
            editor.commit();
            Toast.makeText(this,"registered success",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this,Home.class);
            intent.putExtra("name",n);
            startActivity(intent);
            name.setText("");
            mail.setText("");
            mob.setText("");
            pass.setText("");
            cpass.setText("");
            startActivity(new Intent(this,MainActivity.class));
        }
        else{
            Toast.makeText(this, "password and confirm password should be the same", Toast.LENGTH_SHORT).show();
            pass.setText("");
            cpass.setText("");
        }



    }
}
