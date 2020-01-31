package id.itungin.itung_in.tampil;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import id.itungin.itung_in.R;
import id.itungin.itung_in.tampilperhari.TampilPerHari;

public class TampilAdapter extends RecyclerView.Adapter<TampilAdapter.ViewHolder> {

    private List<ResultItem> rvData;
    private Context mContext;

    public TampilAdapter(List<ResultItem> Data, Context mContext) {
        rvData = Data;
        mContext = mContext;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // di tutorial ini kita hanya menggunakan data String untuk tiap item
        public TextView tanggal;
        public ConstraintLayout root;

        public ViewHolder(View v) {
            super(v);
            tanggal = (TextView) v.findViewById(R.id.tgltmpl);
            root = (ConstraintLayout)v.findViewById(R.id.tampiltgl);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // membuat view baru
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.scroll, parent, false);
        // mengeset ukuran view, margin, padding, dan parameter layout lainnya
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        // - mengambil elemen dari dataset (ArrayList) pada posisi tertentu
        // - mengeset isi view dengan elemen dari dataset tersebut
        ResultItem name = rvData.get(position);
        holder.tanggal.setText(name.getTanggal());
        holder.root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(v.getContext(), TampilPerHari.class);
               intent.putExtra("detailHour",rvData.get(position).getJam());
               intent.putExtra("detailMoney",rvData.get(position).getPemasukkan());
               v.getContext().startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        // menghitung ukuran dataset / jumlah data yang ditampilkan di RecyclerView
        return rvData.size();
    }
}