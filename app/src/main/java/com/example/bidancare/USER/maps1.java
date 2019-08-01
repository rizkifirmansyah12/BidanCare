package com.example.bidancare.USER;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.bidancare.R;
import com.example.bidancare.app.AppController;
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

public class maps1 extends AppCompatActivity/*FragmentActivity implements OnMapReadyCallback*/ {
    TextView idbidan,lat,lng;

   /* MapFragment mapFragment;
    GoogleMap gMap;
    MarkerOptions markerOptions = new MarkerOptions();
    CameraPosition cameraPosition;
    LatLng center, latLng;
    String title;
    TextView idbidan,lat,lng;

    public static final String TAG_ID_bidan       = "id_bidan";
    public static final String TAG_NAMA_bidan     = "nama_bidan";
    public static final String LAT = "lat";
    public static final String LNG = "lng";

    private String url = "http://192.168.8.102/bidancare/api/mapstest1.php";

    String tag_json_obj = "json_obj_req";*/


    /*Deklarasi variable*/
    Button btn_navigasi;
    String goolgeMap = "com.google.android.apps.maps"; // identitas package aplikasi google masps android
    Uri gmmIntentUri;
    Intent mapIntent;
    /*String masjid_agung_demak = "-6.894649906672214,110.63718136399984";*/
    String $a,$b;
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
        String TempHolder = getIntent().getStringExtra("id_bidan");
        idbidan.setText(TempHolder);
        String TempHolder1 = getIntent().getStringExtra("lat");
        lat.setText(TempHolder1);
        String TempHolder2 = getIntent().getStringExtra("lng");
        lng.setText(TempHolder2);
        $a = getString(R.string.latitude);
        $b = getString(R.string.longitude);

        c=$a+","+$b;
/*
        TextView idbidan = (TextView) findViewById(R.id.id_bidan);
        TextView lat = (TextView) findViewById(R.id.lat);
        TextView lng = (TextView) findViewById(R.id.lng);
        String TempHolder = getIntent().getStringExtra("id_bidan");
        idbidan.setText(TempHolder);
        String TempHolder1 = getIntent().getStringExtra("lat");
        lat.setText(TempHolder1);
        String TempHolder2 = getIntent().getStringExtra("lng");
        lng.setText(TempHolder2);

        mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


        @Override
        public void onMapReady(GoogleMap googleMap) {
            gMap = googleMap;

            // Mengarahkan ke alun-alun Demak
            center = new LatLng(-6.894796, 110.638413);
            cameraPosition = new CameraPosition.Builder().target(center).zoom(10).build();
            googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

            getMarkers();
        }

        private void addMarker(LatLng latlng, final String title) {
            markerOptions.position(latlng);
            markerOptions.title(title);
            gMap.addMarker(markerOptions);

            gMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                @Override
                public void onInfoWindowClick(Marker marker) {
                    Toast.makeText(getApplicationContext(), marker.getTitle(), Toast.LENGTH_SHORT).show();
                }
            });
        }

        // Fungsi get JSON marker
        private void getMarkers() {
            StringRequest strReq = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {

                @Override
                public void onResponse(String response) {
                    Log.e("Response: ", response.toString());

                    try {
                        JSONObject jObj = new JSONObject(response);
                        String getObject = jObj.getString("bidans");
                        JSONArray jsonArray = new JSONArray(getObject);

                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            title = jsonObject.getString(TAG_NAMA_bidan);
                            latLng = new LatLng(Double.parseDouble(jsonObject.getString(LAT)), Double.parseDouble(jsonObject.getString(LNG)));

                            // Menambah data marker untuk di tampilkan ke google map
                            addMarker(latLng, title);
                        }

                    } catch (JSONException e) {
                        // JSON error
                        e.printStackTrace();
                    }

                }
            }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e("Error: ", error.getMessage());
                    Toast.makeText(maps1.this, error.getMessage(), Toast.LENGTH_LONG).show();
                }
            });


            AppController.getInstance().addToRequestQueue(strReq, tag_json_obj);*/


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

}
