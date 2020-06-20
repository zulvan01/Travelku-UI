package com.dicoding.assosiate.travelku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void btn_masuk(View view) {
        startActivity(new Intent(getApplicationContext(), SignInActivity.class));
    }
    public void btn_daftar(View view) {
        startActivity(new Intent(getApplicationContext(), SignUpActivity.class));
    }
}
