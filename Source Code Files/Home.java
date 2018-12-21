package com.aruns.smartapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Home extends AppCompatActivity {
    String url = "http://online.tsrtcpass.in/searchPass.do";
    String url1 = "http://online.tsrtcpass.in/counterstupass.do?prm=hyd";
    String url2 = "http://online.tsrtcpass.in/printTicket.do";
    String url3="http://online.tsrtcpass.in/searchPass.do?mode=editDetails";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Intent intent = getIntent();
        String t = intent.getStringExtra("name");
        TextView textView = findViewById(R.id.tv);
        textView.setText(t);
        //System.out.println("Hi" + t +",\n Welcome to Smart Bus Pass App");


    }

    public void openWebPage(String url) {
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void openWebPage(View view) {
        openWebPage(url);
    }

    public void openWebPage1(String url1) {
        Uri webpage = Uri.parse(url1);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }

    public void openWebPage1(View view) {
        openWebPage1(url1);
    }

    public void openWebPage2(String url2) {
        Uri webpage = Uri.parse(url2);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }


    }

    public void openWebPage2(View view) {
        openWebPage2(url2);
    }

    public void renew(View view) {

        startActivity(new Intent(this,Renew.class));
    }
    public void updatedetails(String url3) {
        Uri webpage = Uri.parse(url3);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }


    }
    public void updatedetails(View view) {
        updatedetails(url3);
    }
}

