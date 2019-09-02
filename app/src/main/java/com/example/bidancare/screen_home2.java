package com.example.bidancare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bidancare.ADMIN.Viewbidan;
import com.example.bidancare.ADMIN.login_admin;
import com.example.bidancare.BIDAN.MainActivity;

public class screen_home2 extends AppCompatActivity {
    String  etusername;
    SharedPreferences sharedpreferences;

    Button btnViewProducts;
    Button btnNewProduct;


    public static final String TAG_ID = "id";
    public static final String TAG_USERNAME = "username";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_home2);

        sharedpreferences = getSharedPreferences(loginVer2.my_shared_preferences, Context.MODE_PRIVATE);
        etusername = getIntent().getStringExtra(TAG_USERNAME);

    }

    public void logout(View view) {

        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putBoolean(MainActivity.session_status, false);
        editor.putString(TAG_ID, null);
        editor.putString(TAG_USERNAME, null);
        editor.commit();

        Intent intent = new Intent(screen_home2.this, loginVer2.class);
        finish();
        startActivity(intent);
    }



    public void verifikasi(View view) {
        startActivity(new Intent(screen_home2.this, Viewbidan.class));
    }
}

