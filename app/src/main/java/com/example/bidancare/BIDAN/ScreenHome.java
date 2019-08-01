package com.example.bidancare.BIDAN;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.bidancare.R;

public class ScreenHome extends AppCompatActivity {


    String  etusername;
    SharedPreferences sharedpreferences;

    public static final String TAG_ID = "id";
    public static final String TAG_USERNAME = "username";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_home);

        sharedpreferences = getSharedPreferences(MainActivity.my_shared_preferences, Context.MODE_PRIVATE);

        etusername = getIntent().getStringExtra(TAG_USERNAME);

    }





    public void logout(View view) {

        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putBoolean(MainActivity.session_status, false);
        editor.putString(TAG_ID, null);
        editor.putString(TAG_USERNAME, null);
        editor.commit();

        Intent intent = new Intent(ScreenHome.this, MainActivity.class);
        finish();
        startActivity(intent);


    }

}
