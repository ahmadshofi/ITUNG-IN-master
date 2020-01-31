package id.itungin.itung_in.register;

import androidx.appcompat.app.AppCompatActivity;

import id.itungin.itung_in.MainActivity;
import id.itungin.itung_in.R;
import id.itungin.itung_in.login.Login;
import id.itungin.itung_in.network.BaseApiService;
import id.itungin.itung_in.network.UtilsApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class register extends AppCompatActivity {

    ProgressDialog loading;
    Context mContext;
    BaseApiService mApiService;
    EditText txtUsername, txtPassword,txtName,txtEmail;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mContext = this;
        mApiService = UtilsApi.getAPIService();
        initComponent();
//        TextView gologin = (TextView) findViewById(R.id.pndhlogin);
//
//        gologin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(register.this, Login.class);
//                startActivity(i);
//            }
//        });
//
//        Button gomain = (Button) findViewById(R.id.btnLogin);
//
//        gomain.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(register.this, MainActivity.class);
//                startActivity(i);
//            }
//        });
    }

    private void initComponent() {
        txtName = (EditText) findViewById(R.id.tv_name);
        txtUsername = (EditText) findViewById(R.id.tv_username);
        txtEmail = (EditText) findViewById(R.id.tv_email);
        txtPassword = (EditText) findViewById(R.id.tv_password);
        Button btnRegis = (Button) findViewById(R.id.btn_Register);
        TextView pindahLogin = (TextView) findViewById(R.id.txtPindahLogin);


        btnRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    loading = ProgressDialog.show(mContext,null,"Mohon Bersabar....",true,false);
                    requestRegister();
            }
        });

        pindahLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(register.this,Login.class);
                startActivity(i);
            }
        });

    }

    private void requestRegister() {
        mApiService.registerRequest(txtUsername.getText().toString(),txtName.getText().toString(),txtPassword.getText().toString(),txtEmail.getText().toString())
                .enqueue(new Callback<RegisterResponse>() {
                    @Override
                    public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                        if (response.isSuccessful()){
                            loading.dismiss();
                            if (response.body().getMsg().equals("Success create an account")){
                                Toast.makeText(mContext,"Registrasi Berhasil!!",Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(register.this,Login.class);
                                startActivity(i);
                            }
                            else {
                                Toast.makeText(mContext,"Registrasi Gagal..!!",Toast.LENGTH_SHORT).show();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<RegisterResponse> call, Throwable t) {
                                    t.printStackTrace();
                                    loading.dismiss();
                                    Toast.makeText(mContext,"Koneksi Gagal",Toast.LENGTH_SHORT).show();
                    }
                });

    }


}
