package com.example.bidancare.ADMIN;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bidancare.BIDAN.MainActivity;
import com.example.bidancare.R;
import com.example.bidancare.loginVer2;

public class Home_admin extends AppCompatActivity {
    String  etusername,id;
    SharedPreferences sharedpreferences;

    Button btnViewProducts;
    Button btnNewProduct;


    public static final String TAG_ID = "id_login";
    public static final String TAG_USERNAME = "username";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_admin);

        sharedpreferences = getSharedPreferences(loginVer2.my_shared_preferences, Context.MODE_PRIVATE);
        id = getIntent().getStringExtra(TAG_ID);
        etusername = getIntent().getStringExtra(TAG_USERNAME);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    public void logout(View view) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putBoolean(loginVer2.session_status, false);
        editor.putString(TAG_ID, null);
        editor.putString(TAG_USERNAME, null);
        editor.commit();

        Intent intent = new Intent(Home_admin.this, login_admin.class);
        finish();
        startActivity(intent);
    }

    public void list_bidan(View view) {
        startActivity(new Intent(Home_admin.this, Viewbidan.class));
    }
}
