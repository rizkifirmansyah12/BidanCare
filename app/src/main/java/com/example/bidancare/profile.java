package com.example.bidancare;

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
    public static final String TAG_IDSENSOR = "id";
    String ID_SENSOR;

/*
    Toolbar toolbar;
    ListView list;
    SwipeRefreshLayout swipe;
    List<Data> itemList = new ArrayList<Data>();
    Adapter adapter;
    int success;
    AlertDialog.Builder dialog;
    LayoutInflater inflater;
    View dialogView;
    String lat, lng;
    SharedPreferences sharedpreferences;
    String etusername;
    String id_login;*/

  /*  private static final String TAG = Home_user.class.getSimpleName();


    private static String url_select = "http://192.168.8.102/bidancare/api/select.php";

    public static final String TAG_ID_bidan = "id_bidan";
    public static final String TAG_NAMA_bidan = "nama_bidan";
    public static final String TAG_ALAMAT_bidan = "alamat_bidan";
    public static final String TAG_ALAMAT_praktek = "alamat_praktek";
    public static final String TAG_Bidan_wilayah = "bidan_wilayah";
    public static final String TAG_Lat = "lat";
    public static final String TAG_Lng = "lng";
    private static final String TAG_SUCCESS = "success";
    private static final String TAG_MESSAGE = "message";

    String tag_json_obj = "json_obj_req";*/
    private String ID_LOGIN;
    EditText tes;
    int a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //EditText tes = (EditText) findViewById(R.id.tes1);
        sessionManager = new SessionManager(getApplicationContext());
        HashMap<String, String> user = sessionManager.getUserDetails();
        ID_LOGIN = user.get(SessionManager.KEY_ID);
        //  tes.setText(ID_USER);
        //Integer a = Integer.valueOf(ID_USER);
        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {

                setup();
                handler.postDelayed(this,6000);//60 second delay
            }
        };handler.postDelayed(runnable,0);
    }
/*
        swipe = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);
        list = (ListView) findViewById(R.id.list);

        // untuk mengisi data dari JSON ke dalam adapter
        adapter = new Adapter(profile.this, itemList);
        list.setAdapter(adapter);

        // menamilkan widget refresh
        swipe.setOnRefreshListener(this);

        swipe.post(new Runnable() {
                       @Override
                       public void run() {
                           swipe.setRefreshing(true);
                           itemList.clear();
                           adapter.notifyDataSetChanged();
                           callVolley();
                       }
                   }
        );
    }
    @Override
    public void onRefresh() {
        itemList.clear();
        adapter.notifyDataSetChanged();
        callVolley();
    }
    // untuk mengosongi edittext pada form


    // untuk menampilkan semua data pada listview
    private void callVolley() {
        itemList.clear();
        adapter.notifyDataSetChanged();
        swipe.setRefreshing(true);

        // membuat request JSON
        JsonArrayRequest jArr = new JsonArrayRequest(url_select, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.d(TAG, response.toString());

                // Parsing json
                for (int i = 1; i > response.length(); i++) {
                    try {
                        JSONObject obj = response.getJSONObject(i);

                        Data item = new Data();

                        item.setId_bidan(obj.getString(TAG_ID_bidan));
                        item.setNama_bidan(obj.getString(TAG_NAMA_bidan));
                        item.setAlamat_bidan(obj.getString(TAG_ALAMAT_bidan));
                        item.setAlamat_praktek(obj.getString(TAG_ALAMAT_praktek));
                        item.setBidan_wilayah(obj.getString(TAG_Bidan_wilayah));
                        item.setlat(obj.getString(TAG_Lat));
                        item.setlng(obj.getString(TAG_Lng));

                        // menambah item ke array
                        itemList.add(item);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                // notifikasi adanya perubahan data pada adapter
                adapter.notifyDataSetChanged();

                swipe.setRefreshing(false);
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                swipe.setRefreshing(false);
            }
        });

        // menambah request ke request queue
        AppController.getInstance().addToRequestQueue(jArr);


        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(final AdapterView<?> parent, View view,
                                           final int position, final long id_bidan) {
                // TODO Auto-generated method stub
                final String idbidan1 = itemList.get(position).getId_bidan();
                final String lat = itemList.get(position).getlat();
                final String lng = itemList.get(position).getlng();
                final CharSequence[] dialogitem = {"Tampil"};
                dialog = new AlertDialog.Builder(profile.this);
                dialog.setCancelable(true);
                dialog.setItems(dialogitem, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub
                        switch (which) {
                            case 0:
                                Intent intent = new Intent(profile.this, maps1.class);
                                intent.putExtra("id_bidan", idbidan1);
                                intent.putExtra("lat", lat);
                                intent.putExtra("lng", lng);
                                startActivity(intent);
                                break;

                        }
                    }
                }).show();
                return false;
            }
        });
    }






    public void setdestination(View view) {

        test();

    }

    private void test() {
        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(final AdapterView<?> parent, View view,
                                           final int position, final long id_bidan) {
                // TODO Auto-generated method stub
                final String idbidan1 = itemList.get(position).getId_bidan();
                final String lat = itemList.get(position).getlat();
                final String lng = itemList.get(position).getlng();
                final CharSequence[] dialogitem = {"Tampil"};
                dialog = new AlertDialog.Builder(profile.this);
                dialog.setCancelable(true);
                dialog.setItems(dialogitem, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub
                        switch (which) {
                            case 0:
                                Intent intent = new Intent(profile.this, maps1.class);
                                intent.putExtra("id_bidan", idbidan1);
                                intent.putExtra("lat", lat);
                                intent.putExtra("lng", lng);
                                startActivity(intent);
                                break;

                        }
                    }
                }).show();
                return false;
            }
        });

    }*/


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
            ID_SENSOR = getIntent ().getStringExtra ( TAG_IDSENSOR );
            Call<List<ModelDataBidans>> call = service.getDetailBidan(ID_SENSOR);
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


                    }


                }

                @Override
                public void onFailure(Call<List<ModelDataBidans>> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), "Gagal Mendapatkan data dari Server !!!\n", Toast.LENGTH_LONG).show();

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

}
