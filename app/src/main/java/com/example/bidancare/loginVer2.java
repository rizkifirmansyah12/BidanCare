package com.example.bidancare;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.bidancare.BIDAN.MainActivity;
import com.example.bidancare.USER.Home_user;
import com.example.bidancare.app.AppController;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class loginVer2 extends AppCompatActivity {

   /* private RadioGroup radiogrup;
    private RadioButton radioButtonNb;*/
    ProgressDialog pDialog;
    Button btlogin;
    EditText etusername, etpassword;
    Intent intent;

    int success;
    ConnectivityManager conMgr;

    private String url = Server.URL + "loginver2.php";

    private static final String TAG = loginVer2.class.getSimpleName();

    private static final String TAG_SUCCESS = "success";
    private static final String TAG_MESSAGE = "message";

    public final static String TAG_USERNAME = "username";
    public final static String TAG_Hakakses = "id_grup";



    String tag_json_obj = "json_obj_req";

    SharedPreferences sharedpreferences;
    Boolean session = false;
    String username;
    public static final String my_shared_preferences = "my_shared_preferences";
    public static final String session_status = "session_status";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_ver2);
        /*radiogrup = (RadioGroup) findViewById(R.id.rdgrup);*/


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

        btlogin = (Button) findViewById(R.id.btlogin);
        etusername = (EditText) findViewById(R.id.etusername);
        etpassword = (EditText) findViewById(R.id.etpassword);
        // Cek session login jika TRUE maka langsung buka MainActivity
        sharedpreferences = getSharedPreferences(my_shared_preferences, Context.MODE_PRIVATE);
        session = sharedpreferences.getBoolean(session_status, false);

        username = sharedpreferences.getString(TAG_USERNAME, null);

       /* if (session) {
            Intent intent = new Intent(loginVer2.this, Home.class);
            intent.putExtra(TAG_USERNAME, username);
            finish();
            startActivity(intent);
        }*/


        btlogin.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {
                // TODO Auto-generated method stub
                //pilih radio button yang ada di radio button group
                /*int selectedId = radiogrup.getCheckedRadioButtonId();

                // mencari radio button
                radioButtonNb = (RadioButton) findViewById(selectedId);

                String hakakses = radioButtonNb.getText().toString();*/
                String username = etusername.getText().toString();
                String password = etpassword.getText().toString();

                // mengecek kolom yang kosong
                if (username.trim().length() > 0 && password.trim().length() > 0) {
                    if (conMgr.getActiveNetworkInfo() != null
                            && conMgr.getActiveNetworkInfo().isAvailable()
                            && conMgr.getActiveNetworkInfo().isConnected()) {
                        checkLogin(username, password);//hakakses);
                    } else {
                        Toast.makeText(getApplicationContext(), "No Internet Connection", Toast.LENGTH_LONG).show();
                    }
                } else {
                    // Prompt user to enter credentials
                    Toast.makeText(getApplicationContext(), "Kolom tidak boleh kosong", Toast.LENGTH_LONG).show();
                }
            }
        });


    }


    private void checkLogin(final String username, final String password) {
        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);
        pDialog.setMessage("Logging in ...");
        showDialog();

        StringRequest strReq = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.e(TAG, "Login Response: " + response.toString());
                hideDialog();

                try {
                    JSONObject jObj = new JSONObject(response);
                    success = jObj.getInt(TAG_SUCCESS);

                    // Check for error node in json
                    if (success == 1) {
                        String username = jObj.getString(TAG_USERNAME);
                        /*String hakakses = jObj.getString(TAG_Hakakses);*/

                        Log.e("Successfully Login!", jObj.toString());

                        Toast.makeText(getApplicationContext(), jObj.getString(TAG_MESSAGE), Toast.LENGTH_LONG).show();

                        // menyimpan login ke session
                        SharedPreferences.Editor editor = sharedpreferences.edit();
                        editor.putBoolean(session_status, true);

                        editor.putString(TAG_USERNAME, username);
                        //editor.putString(TAG_Hakakses, hakakses);
                        editor.commit();

                        // Memanggil main activity
                        Intent intent = new Intent(loginVer2.this, screenHomeuser.class);
                        intent.putExtra(TAG_USERNAME, username);
                        //intent.putExtra(TAG_Hakakses, hakakses);
                        finish();
                        startActivity(intent);
                    } else if (success == 2){

                            String username = jObj.getString(TAG_USERNAME);
                            /*String hakakses = jObj.getString(TAG_Hakakses);*/

                            Log.e("Successfully Login!", jObj.toString());

                            Toast.makeText(getApplicationContext(), jObj.getString(TAG_MESSAGE), Toast.LENGTH_LONG).show();

                            // menyimpan login ke session
                            SharedPreferences.Editor editor = sharedpreferences.edit();
                            editor.putBoolean(session_status, true);

                            editor.putString(TAG_USERNAME, username);
                            //editor.putString(TAG_Hakakses, hakakses);
                            editor.commit();

                            // Memanggil main activity
                            Intent intent = new Intent(loginVer2.this, ScreenHome.class);
                            intent.putExtra(TAG_USERNAME, username);
                            //intent.putExtra(TAG_Hakakses, hakakses);
                            finish();
                            startActivity(intent);
                    }else if (success==3){

                            String username = jObj.getString(TAG_USERNAME);
                            /*String hakakses = jObj.getString(TAG_Hakakses);*/

                            Log.e("Successfully Login!", jObj.toString());

                            Toast.makeText(getApplicationContext(), jObj.getString(TAG_MESSAGE), Toast.LENGTH_LONG).show();

                            // menyimpan login ke session
                            SharedPreferences.Editor editor = sharedpreferences.edit();
                            editor.putBoolean(session_status, true);

                            editor.putString(TAG_USERNAME, username);
                            //editor.putString(TAG_Hakakses, hakakses);
                            editor.commit();

                            // Memanggil main activity
                            Intent intent = new Intent(loginVer2.this, screen_home2.class);
                            intent.putExtra(TAG_USERNAME, username);
                            //intent.putExtra(TAG_Hakakses, hakakses);
                            finish();
                            startActivity(intent);
                    }else {
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
                params.put("username", username);
                params.put("password", password);
                //params.put("id_grup", hakakses);

                return params;
            }

        };


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


    public void signup(View view) {startActivity(new Intent(loginVer2.this, ChoiceLog.class));
    }
}
