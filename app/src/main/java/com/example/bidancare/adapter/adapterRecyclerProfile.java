package com.example.bidancare.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.bidancare.R;

import com.example.bidancare.model.ModelDataBidans;
import com.example.bidancare.R;

import java.util.List;

public class adapterRecyclerProfile extends RecyclerView.Adapter<adapterRecyclerProfile.ViewHolder> {

    private List<ModelDataBidans> daftarbidan;
    private Context context;


    public adapterRecyclerProfile(List<ModelDataBidans> daftarbidan, Context ctx){
        /**
         * Inisiasi data dan variabel yang akan digunakan
         */
        this.daftarbidan = daftarbidan;
        this.context = ctx;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate( R.layout.item_profile,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //get the user by its position
        ModelDataBidans user = daftarbidan.get(position);

        //holder.tvSensorName.setText("Sensor Name : " + user.getName() +"\n" +
        //"Sensor Age : " + user.getAge());
        holder.nama_bidan.setText(user.getNama_bidan ());
        holder.alamat_bidan.setText(user.getAlamat_bidan ());
        holder.alamat_praktek.setText(user.getAlamat_praktek ());
        holder.bidan_wilayah.setText(user.getBidan_wilayah ());
        holder.verifikasi.setText(user.getverifkasi());
    }

    @Override
    public int getItemCount() {
        return daftarbidan.size();
    }

    //@Override
    public void clear() {
        daftarbidan.clear ();
    }

    /**
     * inner class
     * here we define all of attribute item in our layout
     */
    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView tvSensorName;
        TextView nama_bidan;
        TextView alamat_bidan;
        TextView alamat_praktek;
        TextView bidan_wilayah;
        TextView verifikasi;

        public ViewHolder(View itemView) {
            super(itemView);
            //tvSensorName = (TextView) itemView.findViewById(R.id.text_view_user_name);
            nama_bidan = (TextView) itemView.findViewById(R.id.nama_bidan);
            alamat_bidan = (TextView) itemView.findViewById(R.id.alamat_bidan);
            alamat_praktek = (TextView) itemView.findViewById(R.id.alamat_praktek);
            bidan_wilayah = (TextView) itemView.findViewById ( R.id.bidan_wilayah);
            verifikasi = (TextView) itemView.findViewById ( R.id.verifikasi);
        }
    }
}