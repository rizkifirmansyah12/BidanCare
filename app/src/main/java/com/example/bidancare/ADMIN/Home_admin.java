package com.example.bidancare.ADMIN;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bidancare.BIDAN.MainActivity;
import com.example.bidancare.R;

public class Home_admin extends AppCompatActivity {
    String  etusername;
    SharedPreferences sharedpreferences;

    Button btnViewProducts;
    Button btnNewProduct;


    public static final String TAG_ID = "id";
    public static final String TAG_USERNAME = "username";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_admin);

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

        Intent intent = new Intent(Home_admin.this, login_admin.class);
        finish();
        startActivity(intent);
    }
}
