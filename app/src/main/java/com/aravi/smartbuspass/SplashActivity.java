package com.aravi.smartbuspass;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class SplashActivity extends AppCompatActivity {

    ImageView imageView;
    ProgressBar progressBar;
    int progress=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        imageView=findViewById(R.id.img);
        progressBar=findViewById(R.id.progressBar);
        //progressBar.setProgress(progress+5);
        progressRun(progress);

        new Handler().postDelayed(new Runnable() {
                                      @Override
                                      public void run() {
                                          progressRun(progress);
                                          startActivity(new Intent(SplashActivity.this,MainActivity.class));
                                          finish();
                                      }
                                  },5*1000
        );
    }

    public void progressRun(final int progress){
        progressBar.setProgress(progress);

        final Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                progressRun(progress+23);
            }
        });
        thread.start();
    }
}
