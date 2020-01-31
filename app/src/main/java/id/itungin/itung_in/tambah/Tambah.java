package id.itungin.itung_in.tambah;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import id.itungin.itung_in.MainActivity;
import id.itungin.itung_in.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class Tambah extends AppCompatActivity {

    private RecyclerView rvView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<String> dataSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);

        Button Back = (Button) findViewById(R.id.back);

        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Tambah.this, MainActivity.class);
                startActivity(i);
            }
        });

        dataSet = new ArrayList<>();
        initDataset();

        rvView = (RecyclerView) findViewById(R.id.receycleviewtambah);
        rvView.setHasFixedSize(true);

        /**
         * Kita menggunakan LinearLayoutManager untuk list standar
         * yang hanya berisi daftar item
         * disusun dari atas ke bawah
         */
        layoutManager = new LinearLayoutManager(this);
        rvView.setLayoutManager(layoutManager);

        adapter = new AdapterTambah(dataSet);
        rvView.setAdapter(adapter);
//
    }

    private void initDataset() {

        dataSet.add("Rp 10.000.000");
        dataSet.add("Rp 20.000.000");
        dataSet.add("Rp 30.000.000");
        dataSet.add("Rp 40.000.000");
        dataSet.add("Rp 50.000.000");
        dataSet.add("Rp 60.000.000");
        dataSet.add("Rp 70.000.000");
        dataSet.add("Rp 80.000.000");
        dataSet.add("Rp 90.000.000");
        dataSet.add("Rp 110.000.000");

    }


}
