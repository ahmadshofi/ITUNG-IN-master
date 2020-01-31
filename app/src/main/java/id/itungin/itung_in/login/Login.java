package id.itungin.itung_in.login;

import androidx.appcompat.app.AppCompatActivity;
import id.itungin.itung_in.MainActivity;
import id.itungin.itung_in.R;
import id.itungin.itung_in.network.BaseApiService;
import id.itungin.itung_in.network.UtilsApi;
import id.itungin.itung_in.register.register;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    ProgressDialog loading;
    Context mContext;
    BaseApiService mApiService;
    EditText txtUsername, txtPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        mContext = this;
        mApiService = UtilsApi.getAPIService(); // meng-init yang ada di package apihelper
        initComponents();
    }

    private void initComponents() {
        txtUsername = (EditText) findViewById(R.id.edt_username);
        txtPassword = (EditText) findViewById(R.id.edt_password);
        Button gomain = (Button) findViewById(R.id.btnLogin);
        TextView goregister = (TextView) findViewById(R.id.pndhregister);

        gomain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loading = ProgressDialog.show(mContext,null,"Harap Tunggu...",true,false);
                requestLogin();
            }
        });

        goregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent i = new Intent(Login.this, register.class);
                    startActivity(i);
            }
        });


    }

    private void requestLogin() {
        mApiService.loginRequest(txtUsername.getText().toString(), txtPassword.getText().toString())
                .enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                        if (response.isSuccessful()){
                            loading.dismiss();
                            if (response.body().getMsg().equals("Succes Login")){
                                Toast.makeText(mContext, "BERHASIL LOGIN", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(mContext, MainActivity.class);
                                startActivity(intent);
                                finish();
                            }
                            else {
                                Toast.makeText(mContext, "Login gagal!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {
                        t.printStackTrace();
                        loading.dismiss();
                        Toast.makeText(mContext, "Login gagal!", Toast.LENGTH_SHORT).show();
                    }
                });

    }
}
