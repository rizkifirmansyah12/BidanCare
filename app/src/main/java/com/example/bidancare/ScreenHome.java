package com.example.bidancare;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bidancare.BIDAN.MainActivity;
import com.example.bidancare.Manager.SessionManager;

public class ScreenHome extends AppCompatActivity {
    SessionManager sessionManager;

    String  etusername;
    SharedPreferences sharedpreferences;
    Button btlogout;

    public static final String TAG_ID = "id";
    public static final String TAG_USERNAME = "username";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_home);
        sessionManager = new SessionManager(getApplicationContext());
        sharedpreferences = getSharedPreferences(loginVer2.my_shared_preferences, Context.MODE_PRIVATE);

        etusername = getIntent().getStringExtra(TAG_USERNAME);



    }

    public void profile(View view) {
        Intent intent = new Intent(ScreenHome.this, profile.class);
        finish();
        startActivity(intent);
    }

    public void changeschedule(View view) {
        Intent intent = new Intent(ScreenHome.this, ChangeSchedule.class);
        finish();
        startActivity(intent);
    }

    public void keluar(View view) {
        sessionManager.logoutUser ();
        Intent intent = new Intent(ScreenHome.this, loginVer2.class);
        finish();
        startActivity(intent);
    }
}
