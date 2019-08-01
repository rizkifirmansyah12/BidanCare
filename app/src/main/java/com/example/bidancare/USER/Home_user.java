package com.example.bidancare.USER;

import android.content.DialogInterface;
import android.content.Intent;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toolbar;

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

public class Home_user extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {
    Toolbar toolbar;
    ListView list;
    SwipeRefreshLayout swipe;
    List<Data> itemList = new ArrayList<Data>();
    Adapter adapter;
    int success;
    AlertDialog.Builder dialog;
    LayoutInflater inflater;
    View dialogView;

    private static final String TAG = Home_user.class.getSimpleName();

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


    String tag_json_obj = "json_obj_req";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_user);
        Button button1 = (Button)findViewById(R.id.button1);


/*
        button1.OnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v){

                *//**
                 * Passing data via Intent
                 *//*

                Intent intent = new Intent(Home_user.this, maps1.class);
                intent.putExtra("id_bidan",TAG_ID_bidan.indexOf("id_bidan"));
                startActivity(intent);
            }
        });*/
        // menghubungkan variablel pada layout dan pada java

        swipe = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);
        list = (ListView) findViewById(R.id.list);

        // untuk mengisi data dari JSON ke dalam adapter
        adapter = new Adapter(Home_user.this, itemList);
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
                for (int i = 0; i < response.length(); i++) {
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
                    dialog = new AlertDialog.Builder(Home_user.this);
                    dialog.setCancelable(true);
                    dialog.setItems(dialogitem, new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // TODO Auto-generated method stub
                            switch (which) {
                                case 0:
                                    Intent intent = new Intent(Home_user.this, maps1.class);
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
                dialog = new AlertDialog.Builder(Home_user.this);
                dialog.setCancelable(true);
                dialog.setItems(dialogitem, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub
                        switch (which) {
                            case 0:
                                Intent intent = new Intent(Home_user.this, maps1.class);
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
}


