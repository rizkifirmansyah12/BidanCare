package com.example.bidancare;

import android.content.Intent;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.example.bidancare.Manager.SessionManager;

public class Splash extends AppCompatActivity {
    private static int SPLASH_TIME_OUT=4000;
    SessionManager sessionManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run(){

                Intent homeIntent = new Intent(Splash.this, loginVer2.class);
                startActivity(homeIntent);
                finish();
            }

        },SPLASH_TIME_OUT);
        /*final Intent i;
        sessionManager = new SessionManager(getApplicationContext());

        if(sessionManager.isLoggedIn()==true){
            i= new Intent(this,ScreenHome.class);
            Thread timer = new Thread(){
                public void run(){
                    try{
                        sleep(1000);
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    finally{
                        startActivity(i);
                        finish();
                    }
                }
            };
            timer.start();
        }else{
            i= new Intent(this,loginVer2.class);
            Thread timer = new Thread(){
                public void run(){
                    try{
                        sleep(250);
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    finally{
                        startActivity(i);
                        finish();
                    }
                }
            };
            timer.start();
        }*/
    }
}
