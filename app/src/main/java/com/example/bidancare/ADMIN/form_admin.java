package com.example.bidancare.ADMIN;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.bidancare.R;
import com.example.bidancare.adapter.Adapter;
import com.example.bidancare.app.AppController;
import com.example.bidancare.data.Data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class form_admin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_admin);
        TextView idbidan = (TextView) findViewById(R.id.id_bidan);
        String TempHolder = getIntent().getStringExtra("id_bidan");
        idbidan.setText(TempHolder);
    }

}
