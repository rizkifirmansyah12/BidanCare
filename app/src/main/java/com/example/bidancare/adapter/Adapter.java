package com.example.bidancare.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.bidancare.R;
import com.example.bidancare.data.Data;

import java.util.List;

public class Adapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Data> items;

    public Adapter(Activity activity, List<Data> items) {
        this.activity = activity;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int location) {
        return items.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null)
            convertView = inflater.inflate(R.layout.list_row, null);

        TextView id_bidan = (TextView) convertView.findViewById(R.id.id_bidan);
        TextView nama_bidan = (TextView) convertView.findViewById(R.id.nama_bidan);
        TextView alamat_bidan = (TextView) convertView.findViewById(R.id.alamat_bidan);
        TextView alamat_praktek = (TextView) convertView.findViewById(R.id.alamat_praktek);
        TextView bidan_wilayah = (TextView) convertView.findViewById(R.id.bidan_wilayah);


        Data data = items.get(position);

        id_bidan.setText(data.getId_bidan());
        nama_bidan.setText(data.getNama_bidan());
        alamat_bidan.setText(data.getAlamat_bidan());
        alamat_praktek.setText(data.getAlamat_praktek());
        bidan_wilayah.setText(data.getBidan_wilayah());

        return convertView;
    }
}
