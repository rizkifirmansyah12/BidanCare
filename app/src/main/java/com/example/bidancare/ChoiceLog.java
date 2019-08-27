package com.example.bidancare;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.bidancare.BIDAN.Sign_bidan;
import com.example.bidancare.USER.Home_user;

public class ChoiceLog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice_log);
    }

    public void bidan(View view) {
        startActivity(new Intent(ChoiceLog.this, Sign_bidan.class));
    }

    public void admin(View view) {
        startActivity(new Intent(ChoiceLog.this, sign_admin_user.class));
    }
}
