package id.itungin.itung_in.tampilperhari;


import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import id.itungin.itung_in.R;

public class RecylerViewTampilPeHari extends RecyclerView.Adapter<RecylerViewTampilPeHari.ViewHolder> {

    private ArrayList<String> rvData;

    public RecylerViewTampilPeHari(ArrayList<String> inputData) {
        rvData = inputData;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // di tutorial ini kita hanya menggunakan data String untuk tiap item
        public TextView tanggal;
        public ConstraintLayout root;

        public ViewHolder(View v) {
            super(v);
            tanggal = (TextView) v.findViewById(R.id.tgltmpl);
            root = (ConstraintLayout)v.findViewById(R.id.tampilperhari);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // membuat view baru
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.scroll_tampilperhari, parent, false);
        // mengeset ukuran view, margin, padding, dan parameter layout lainnya
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final String name = rvData.get(position);
        holder.tanggal.setText(rvData.get(position));
        holder.root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

    }


    @Override
    public int getItemCount() {
        // menghitung ukuran dataset / jumlah data yang ditampilkan di RecyclerView
        return rvData.size();
    }
}
