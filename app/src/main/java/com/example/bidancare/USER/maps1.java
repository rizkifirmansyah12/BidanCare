package com.example.bidancare.USER;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.bidancare.ADMIN.Home_admin;
import com.example.bidancare.API.ApiService;
import com.example.bidancare.ChoiceLog;
import com.example.bidancare.Home;
import com.example.bidancare.R;
import com.example.bidancare.Server;
import com.example.bidancare.adapter.adapterRecyclerProfile;
import com.example.bidancare.app.AppController;
import com.example.bidancare.model.ModelDataBidans;
import com.example.bidancare.sign_admin_user;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class maps1 extends AppCompatActivity/*FragmentActivity implements OnMapReadyCallback*/ {
    TextView idbidan,lat,lng;

    private RecyclerView rvSensor;
    private List<ModelDataBidans> daftarbidan;
    private adapterRecyclerProfile mdaftarbidan;
    /*Deklarasi variable*/
    Button btn_navigasi;
    String goolgeMap = "com.google.android.apps.maps"; // identitas package aplikasi google masps android
    Uri gmmIntentUri;
    Intent mapIntent;
    /*String masjid_agung_demak = "-6.894649906672214,110.63718136399984";*/
    String a,b,d;
    String c;
    // koordinat Masjid Agung Demak
    /*Deklarasi variable*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps1);

        TextView idbidan = (TextView) findViewById(R.id.id_bidan);
        TextView lat = (TextView) findViewById(R.id.lat);
        TextView lng = (TextView) findViewById(R.id.lng);
        TextView test = (TextView) findViewById(R.id.test);
        String TempHolder = getIntent().getStringExtra("id_bidan");
        idbidan.setText(TempHolder);
        String TempHolder1 = getIntent().getStringExtra("lat");
        lat.setText(TempHolder1);
        String TempHolder2 = getIntent().getStringExtra("lng");
        lng.setText(TempHolder2);
        a= TempHolder1;
        b = TempHolder2;
        d = TempHolder;


        c=  a+','+b;
        test.setText(c);

        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {

                setup();
                handler.postDelayed(this,6000);//60 second delay
            }
        };handler.postDelayed(runnable,0);

        // menyamakan variable pada layout activity_main.xml
        btn_navigasi    = (Button) findViewById(R.id.btnNext);

        // tombol untuk menjalankan navigasi goolge maps intents
        btn_navigasi.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Buat Uri dari intent string. Gunakan hasilnya untuk membuat Intent.
                gmmIntentUri = Uri.parse("google.navigation:q=" + c);

                // Buat Uri dari intent gmmIntentUri. Set action => ACTION_VIEW
                mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);

                // Set package Google Maps untuk tujuan aplikasi yang di Intent yaitu google maps
                mapIntent.setPackage(goolgeMap);

                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapIntent);
                } else {
                    Toast.makeText(maps1.this, "Google Maps Belum Terinstal. Install Terlebih dahulu.",
                            Toast.LENGTH_LONG).show();
                }
            }

        });
    }
    public void setup() {
        //listview = (ListView) rootView.findViewById(R.id.listSensor);
        rvSensor = (RecyclerView) findViewById(R.id.RecyclerView_Bidan);
        daftarbidan = new ArrayList<>();
        //passing to adapter
        mdaftarbidan = new adapterRecyclerProfile(daftarbidan, getApplication ());
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
        Call<List<ModelDataBidans>> call = service.getDetailBidan(d);
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
        startActivity(new Intent(maps1.this, Home_user.class));

    }
}
