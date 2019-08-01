package com.example.bidancare.ADMIN;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bidancare.BIDAN.MainActivity;
import com.example.bidancare.R;

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

        sharedpreferences = getSharedPreferences(MainActivity.my_shared_preferences, Context.MODE_PRIVATE);
        etusername = getIntent().getStringExtra(TAG_USERNAME);

    }

    public void logout(View view) {

        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putBoolean(MainActivity.session_status, false);
        editor.putString(TAG_ID, null);
        editor.putString(TAG_USERNAME, null);
        editor.commit();

        Intent intent = new Intent(screen_home2.this, login_admin.class);
        finish();
        startActivity(intent);
    }

    public void listbidan(View view) {
        startActivity(new Intent(screen_home2.this, Viewbidan.class));
    }
}

