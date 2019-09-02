package com.example.bidancare.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelDataBidans {
    @SerializedName("nama_bidan")
    @Expose
    public String nama_bidan;

    @SerializedName("alamat_bidan")
    @Expose
    public String alamat_bidan;

    @SerializedName("alamat_praktek")
    @Expose
    public String alamat_praktek;

    @SerializedName("bidan_wilayah")
    @Expose
    public String bidan_wilayah;

    @SerializedName("verifikasi")
    @Expose
    public String verifikasi;

    public static final String id_login = "id_login";

    public ModelDataBidans(String nama_bidan, String alamat_bidan, String alamat_praktek, String bidan_wilayah, String verifikasi) {
        this.nama_bidan = nama_bidan;
        this.alamat_bidan = alamat_bidan;
        this.alamat_praktek = alamat_praktek;
        this.bidan_wilayah = bidan_wilayah;
        this.verifikasi= verifikasi;
    }

    public String getNama_bidan() {
        return nama_bidan;
    }

    public void setNama_bidan(String nama_bidan) {
        this.nama_bidan = nama_bidan;
    }

    public String getAlamat_bidan() {
        return alamat_bidan;
    }

    public void setAlamat_bidan(String alamat_bidan) {
        this.alamat_bidan = alamat_bidan;
    }

    public String getAlamat_praktek() {
        return alamat_praktek;
    }

    public void setAlamat_praktek(String alamat_praktek) {
        this.alamat_praktek = alamat_praktek;
    }

    public String getBidan_wilayah() {
        return bidan_wilayah;
    }

    public void setBidan_wilayah(String bidan_wilayah) {
        this.bidan_wilayah = bidan_wilayah;
    }

    public String getverifkasi() {
        return verifikasi;
    }

    public void setverifikasi(String verifikasi) {
        this.verifikasi = verifikasi;
    }

}
