package id.itungin.itung_in.tampil;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import id.itungin.itung_in.MainActivity;
import id.itungin.itung_in.R;
import id.itungin.itung_in.network.BaseApiService;
import id.itungin.itung_in.network.RetrofitClient;
import id.itungin.itung_in.network.UtilsApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class Tampil extends AppCompatActivity {

    private RecyclerView rvView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<ResultItem> dataSet;
    BaseApiService mApiService;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil);


        Button Back = (Button) findViewById(R.id.back);

        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Tampil.this, MainActivity.class);
                startActivity(i);
            }
        });

        mContext = this;
        mApiService = UtilsApi.getAPIService();
        initComponent();
}

    private void initComponent() {
        rvView = (RecyclerView) findViewById(R.id.receycleviewtgl);
        rvView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(mContext);
        rvView.setLayoutManager(layoutManager);
        mApiService.getList().enqueue(new Callback<DataResponse>() {
            @Override
            public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {
                if (response.body().getResult().size() > 0){
                    dataSet = response.body().getResult();
                    adapter = new TampilAdapter(dataSet,Tampil.this);
                    rvView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }
                else {

                }
            }

            @Override
            public void onFailure(Call<DataResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
