package com.example.bidancare;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.bidancare.API.ApiService;
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
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class update_profile extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {
    Toolbar toolbar;
    ListView list;
    SwipeRefreshLayout swipe;
    List<Data> itemList = new ArrayList<Data>();
    Adapter adapter;
    int success;
    AlertDialog.Builder dialog;
    LayoutInflater inflater;
    View dialogView;
    String lat,lng;
    SharedPreferences sharedpreferences;
    private static final String TAG = update_profile.class.getSimpleName();

    private static String url_select = "http://192.168.8.102/bidancare/api/select.php";

    public static final String TAG_ID_bidan = "id_bidan";
    public static final String TAG_NAMA_bidan = "nama_bidan";
    public static final String TAG_ALAMAT_bidan = "alamat_bidan";
    public static final String TAG_ALAMAT_praktek = "alamat_praktek";
    public static final String TAG_Bidan_wilayah = "bidan_wilayah";
    public static final String TAG_Lat = "lat";
    public static final String TAG_Lng = "lng";
    public static final String TAG_Opsi = "opsi";
    private static final String TAG_SUCCESS = "success";
    private static final String TAG_MESSAGE = "message";


    String tag_json_obj = "json_obj_req";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);





    swipe = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);
    list = (ListView) findViewById(R.id.list);

    // untuk mengisi data dari JSON ke dalam adapter
    adapter = new Adapter(update_profile .this, itemList);
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
        JsonArrayRequest jArr = new JsonArrayRequest(url_select, new com.android.volley.Response.Listener<JSONArray>() {
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
                        item.setopsi(obj.getString(TAG_Opsi));

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


    }
}
