package com.example.bidancare;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.bidancare.BIDAN.MainActivity;
import com.example.bidancare.Manager.SessionManager;

public class ScreenHome extends AppCompatActivity {
    SessionManager sessionManager;

    String  etusername;
    SharedPreferences sharedpreferences;

    public static final String TAG_ID = "id";
    public static final String TAG_USERNAME = "username";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_home);

        sharedpreferences = getSharedPreferences(loginVer2.my_shared_preferences, Context.MODE_PRIVATE);

        etusername = getIntent().getStringExtra(TAG_USERNAME);

    }





    public void logout(View view) {
/*        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putBoolean(MainActivity.session_status, false);
        editor.putString(TAG_ID, null);
        editor.putString(TAG_USERNAME, null);
        editor.commit();

        Intent intent = new Intent(ScreenHome.this, loginVer2.class);
        finish();
        startActivity(intent);*/
        sessionManager.logout ();
        Intent intent = new Intent(ScreenHome.this, loginVer2.class);
        finish();
        startActivity(intent);



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
}
