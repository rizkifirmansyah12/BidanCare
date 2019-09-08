package com.example.bidancare.ADMIN;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.example.bidancare.Manager.SessionManager;
import com.example.bidancare.R;
import com.example.bidancare.Server;
import com.example.bidancare.USER.Home_user;
import com.example.bidancare.USER.maps1;
import com.example.bidancare.adapter.Adapter;
import com.example.bidancare.app.AppController;
import com.example.bidancare.data.Data;
import com.example.bidancare.loginVer2;
import com.example.bidancare.sign_admin_user;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class form_admin extends AppCompatActivity {
    private RadioGroup radiogrup;
    private RadioButton radioButtonNb;

    ProgressDialog pDialog;
    ConnectivityManager conMgr;
    private static final String TAG = form_admin.class.getSimpleName();


    private static String url_update     = Server.URL + "update_verif.php";

    public static final String TAG_ID       = "id_login";
    public static final String TAG_Lat     = "latitude";
    public static final String TAG_Lng  = "longitude";
    public static final String TAG_Verif = "verifikasi";
    private static final String TAG_SUCCESS = "success";
    private static final String TAG_MESSAGE = "message";
    private String id_login;
    String tag_json_obj = "json_obj_req";

    EditText txt_lat, txt_lng, txt_verif;
    Button btn_verif,btn_back;
    int success;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_admin);
        TextView idbidan = (TextView) findViewById(R.id.id_bidan);
        final String TempHolder = getIntent().getStringExtra("id_bidan");
        idbidan.setText(TempHolder);
        conMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        {
            if (conMgr.getActiveNetworkInfo() != null
                    && conMgr.getActiveNetworkInfo().isAvailable()
                    && conMgr.getActiveNetworkInfo().isConnected()) {
            } else {
                Toast.makeText(getApplicationContext(), "No Internet Connection",
                        Toast.LENGTH_LONG).show();
            }
        }

        btn_verif = (Button) findViewById(R.id.btn_verif);
        radiogrup = (RadioGroup) findViewById(R.id.rdverifikasi);

        txt_lat = (EditText) findViewById(R.id.txt_lat);
        txt_lng = (EditText) findViewById(R.id.txt_lng);

        btn_verif.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String lat = txt_lat.getText().toString();
                String lng = txt_lng.getText().toString();

               //edit(TempHolder);
                int selectedId = radiogrup.getCheckedRadioButtonId();

                // mencari radio button
                radioButtonNb = (RadioButton) findViewById(selectedId);

                String verif = radioButtonNb.getText().toString();

                if (conMgr.getActiveNetworkInfo() != null
                        && conMgr.getActiveNetworkInfo().isAvailable()
                        && conMgr.getActiveNetworkInfo().isConnected()) {
                    checkverif(lat, lng,verif,TempHolder);
                } else {
                    Toast.makeText(getApplicationContext(), "No Internet Connection", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


    private void checkverif(final String lat, final String lng, final String verif, final String TempHolder) {
        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);
        pDialog.setMessage("Register ...");
        showDialog();

        StringRequest strReq = new StringRequest(Request.Method.POST, url_update, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.e(TAG, "Register Response: " + response.toString());
                hideDialog();

                try {
                    JSONObject jObj = new JSONObject(response);
                    success = jObj.getInt(TAG_SUCCESS);

                    // Check for error node in json
                    if (success == 1) {
                        //String hakakses = jObj.getString(TAG_Hakakses);
                        Log.e("Successfully Register!", jObj.toString());

                        Toast.makeText(getApplicationContext(),
                                jObj.getString(TAG_MESSAGE), Toast.LENGTH_LONG).show();

                        txt_lat.setText("");
                        txt_lng.setText("");
                        radioButtonNb.setText("");

                    } else {
                        Toast.makeText(getApplicationContext(),
                                jObj.getString(TAG_MESSAGE), Toast.LENGTH_LONG).show();

                    }
                } catch (JSONException e) {
                    // JSON error
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Login Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_LONG).show();

                hideDialog();

            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                // Posting parameters to login url
                Map<String, String> params = new HashMap<String, String>();
                params.put("id_bidan", TempHolder);
                params.put("lat", lat);
                params.put("lng", lng);
                params.put("verif", verif);

                return params;
            }

        };

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(strReq, tag_json_obj);
    }
    private void showDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hideDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(form_admin.this, Viewbidan.class));

    }

    public void back(View view) {
        startActivity(new Intent(form_admin.this, Viewbidan.class));

    }
}
