package com.example.bidancare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.bidancare.ADMIN.Viewbidan;
import com.example.bidancare.BIDAN.MainActivity;
import com.example.bidancare.USER.Home_user;

public class screenHomeuser extends AppCompatActivity {

    String  etusername;
    SharedPreferences sharedpreferences;

    public static final String TAG_ID = "id";
    public static final String TAG_USERNAME = "username";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_homeuser);
        sharedpreferences = getSharedPreferences(loginVer2.my_shared_preferences, Context.MODE_PRIVATE);

        etusername = getIntent().getStringExtra(TAG_USERNAME);

    }

    public void listbidan(View view) {
        startActivity(new Intent(screenHomeuser.this, Home_user.class));
    }

    public void logout(View view) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putBoolean(MainActivity.session_status, false);
        editor.putString(TAG_ID, null);
        editor.putString(TAG_USERNAME, null);
        editor.commit();

        Intent intent = new Intent(screenHomeuser.this, loginVer2.class);
        finish();
        startActivity(intent);
    }
}
