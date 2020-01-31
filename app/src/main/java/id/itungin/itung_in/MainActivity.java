package id.itungin.itung_in;

import androidx.appcompat.app.AppCompatActivity;
import id.itungin.itung_in.login.Login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button Logout = (Button) findViewById(R.id.logout);

        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Login.class);
                startActivity(i);
            }
        });

        Button Profile = (Button) findViewById(R.id.profile);

        Profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Profile.class);
                startActivity(i);
            }
        });

        Button Tambah = (Button) findViewById(R.id.btntambah);

        Tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, id.itungin.itung_in.tambah.Tambah.class);
                startActivity(i);
            }
        });

        Button Tampil = (Button) findViewById(R.id.btntampil);

        Tampil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, id.itungin.itung_in.tampil.Tampil.class);
                startActivity(i);
            }
        });
    }
}
