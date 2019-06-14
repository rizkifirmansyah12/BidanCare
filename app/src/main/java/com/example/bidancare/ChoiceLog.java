package com.example.bidancare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ChoiceLog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice_log);
    }

    public void bidan(View view) {
        startActivity(new Intent(ChoiceLog.this,MainActivity.class));
    }

    public void user(View view) {
    }

    public void admin(View view) {
        startActivity(new Intent(ChoiceLog.this,login_admin.class));
    }
}
