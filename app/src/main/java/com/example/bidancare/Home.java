package com.example.bidancare;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Home extends AppCompatActivity {


    String  etusername;
    SharedPreferences sharedpreferences;

    public static final String TAG_ID = "id";
    public static final String TAG_USERNAME = "username";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        sharedpreferences = getSharedPreferences(MainActivity.my_shared_preferences, Context.MODE_PRIVATE);

        etusername = getIntent().getStringExtra(TAG_USERNAME);




        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void logout(View view) {

            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putBoolean(MainActivity.session_status, false);
            editor.putString(TAG_ID, null);
            editor.putString(TAG_USERNAME, null);
            editor.commit();

            Intent intent = new Intent(Home.this, MainActivity.class);
            finish();
            startActivity(intent);


    }
}
