package com.example.bidancare.data;

public class Data {

        private String id, id_bidan, nama_bidan, alamat_bidan, alamat_praktek, bidan_wilayah,verifkasi,lat,lng,opsi;

        public Data() {
        }

        public Data(String id, String id_bidan, String nama_bidan, String alamat_bidan, String alamat_praktek, String bidan_wilayah, String verifikasi, String lat, String lng, String opsi) {
            this.id = id;
            this.id_bidan = id_bidan;
            this.nama_bidan = nama_bidan;
            this.alamat_bidan = alamat_bidan;
            this.alamat_praktek = alamat_praktek;
            this.bidan_wilayah = bidan_wilayah;
            this.verifkasi=verifikasi;
            this.lat = lat;
            this.lng=lng;
            this.opsi=opsi;
        }

        public String getId_bidan() {
            return id_bidan;
        }

        public void setId_bidan(String id_bidan) {
            this.id_bidan = id_bidan;
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
        return verifkasi;
    }

    public void setverifkasi(String verifkasi) {
        this.verifkasi = verifkasi;
    }

    public String getlat() {
        return lat;
    }

    public void setlat(String lat) {
        this.lat = lat;
    }


    public String getlng() {
        return lng;
    }

    public void setlng(String lng) {
        this.lng = lng;
    }

    public String getopsi() {
        return opsi;
    }

    public void setopsi(String opsi) {
        this.opsi = opsi;
    }


}

