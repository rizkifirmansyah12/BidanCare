package com.example.bidancare.API;

import com.example.bidancare.model.ModelDataBidans;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {
    //@FormUrlEncoded

//
//    @FormUrlEncoded
//    @POST("hapus_data.php")
//    Call<ResponseBody> hapusData(@Field("id_barang") String id_barang);

    //   @GET("lihat_data_sensor.php")
    //   Call<List<ModelData>> getSemuaSensor(@Query("id_user") String id_user);

    @GET("selectprofile.php")
    Call<List<ModelDataBidans>> getDetailBidan(@Query("id_login") String id_login);



    /*@GET("lihat_data_sensor_dht_notifikasi.php")
    Call<List<ModelDataBidans>> getDetailSensorDHTNotifikasi(@Query("id_sensor") String id_sensor);*/


//    @GET("single_data.php")
//    Call<List<ModelData>> getSingleData(@Query("id_barang") String id);
}
