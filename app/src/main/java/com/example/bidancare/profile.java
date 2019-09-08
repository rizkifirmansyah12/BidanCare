package com.example.bidancare;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.bidancare.API.ApiService;
import com.example.bidancare.Manager.SessionManager;
import com.example.bidancare.USER.Home_user;
import com.example.bidancare.USER.maps1;
import com.example.bidancare.adapter.Adapter;
import com.example.bidancare.adapter.adapterRecyclerProfile;
import com.example.bidancare.app.AppController;
import com.example.bidancare.data.Data;
import com.example.bidancare.model.ModelDataBidans;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TransferQueue;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.bidancare.ScreenHome.TAG_USERNAME;

public class profile extends AppCompatActivity {//implements SwipeRefreshLayout.OnRefreshListener {
    SessionManager sessionManager;

    private RecyclerView rvSensor;
    private List<ModelDataBidans> daftarbidan;
    private adapterRecyclerProfile mdaftarbidan;
    public static final String TAG_IDSENSOR = "1";
    //String ID_SENSOR;

  public static final String TAG_ID_bidan = "id_bidan";
    private String id_login;
    EditText tes;
    int a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //EditText tes = (EditText) findViewById(R.id.tes1);
        sessionManager = new SessionManager(getApplicationContext());
        HashMap<String, String> user = sessionManager.getUserDetails();
        id_login = user.get(SessionManager.KEY_ID);
        //  tes.setText(ID_USER);
        //Integer a = Integer.valueOf(ID_USER);
//        ActionBar menu = getSupportActionBar ();
//        menu.setDisplayShowHomeEnabled ( true );
//        menu.setDisplayHomeAsUpEnabled ( true );
        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {

                setup();
                handler.postDelayed(this,6000);//60 second delay
            }
        };handler.postDelayed(runnable,0);
    }



        public void setup() {
            //listview = (ListView) rootView.findViewById(R.id.listSensor);
            rvSensor = (RecyclerView) findViewById(R.id.RecyclerView_Bidan);
            daftarbidan = new ArrayList<>();
            //passing to adapter
            mdaftarbidan = new adapterRecyclerProfile (daftarbidan, getApplication ());
            rvSensor.setLayoutManager(new LinearLayoutManager(getApplication()));
            rvSensor.setItemAnimator(new DefaultItemAnimator());
            rvSensor.setAdapter(mdaftarbidan);
            mdaftarbidan.notifyDataSetChanged();
            //listview.setOnItemClickListener ( SensorFragment.this );
            //listview.setDividerHeight(0);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Server.URL)
                    .addConverterFactory( GsonConverterFactory.create())
                    .build();

            ApiService service = retrofit.create(ApiService.class);
            /*ID_SENSOR = getIntent ().getStringExtra ( TAG_IDSENSOR );*/
            //id_login=getIntent().getStringExtra(TAG_ID_bidan);
            Call<List<ModelDataBidans>> call = service.getDetailBidan(id_login);
            call.enqueue(new Callback<List<ModelDataBidans>>() {
                @Override
                public void onResponse(Call<List<ModelDataBidans>> call, Response<List<ModelDataBidans>> response) {

                    if (response.isSuccessful()) {
                        int jumlah = response.body().size();
                        daftarbidan.clear();

                        for (int i = 0; i < jumlah; i++) {

                            ModelDataBidans data = new ModelDataBidans(
                                    response.body().get(i).getNama_bidan(),
                                    response.body().get(i).getAlamat_bidan(),
                                    response.body().get(i).getAlamat_praktek(),
                                    response.body().get(i).getBidan_wilayah(),
                                    response.body().get(i).getverifkasi()
                            );
                            daftarbidan.add(data);
                            Log.d("RESPON", "onResponse: " + response.body().get(i).getNama_bidan());

                        }
                        rvSensor.setVisibility(View.VISIBLE);
                        mdaftarbidan = new adapterRecyclerProfile(daftarbidan, getApplication());
                        rvSensor.setAdapter(mdaftarbidan);

                        if (mdaftarbidan.getItemCount () < 1 ) {
                            Toast.makeText(getApplicationContext(), "Data Kosong !!!\n", Toast.LENGTH_LONG).show();

                        } else {

                            //Toast.makeText(getApplicationContext(), "============\n", Toast.LENGTH_LONG).show();

                        }
                    }else {
                        Toast.makeText(getApplicationContext(), "Gagal Mendapatkan data dari Server !!!\n", Toast.LENGTH_LONG).show();
                    }


                }

                @Override
                public void onFailure(Call<List<ModelDataBidans>> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), "Gagal Mendapatkan data dari Server 1 !!!\n", Toast.LENGTH_LONG).show();

                }
            });
        }

        @Override
        public void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == 1) {
                mdaftarbidan.clear();
                setup();
            }
        }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(profile.this, ScreenHome.class));

    }
}
