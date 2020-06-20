package com.dicoding.assosiate.travelku;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;


public class DashboardActivity extends AppCompatActivity {
    FrameLayout Indonesia,Singapura,New_York,Australia,Belanda;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Indonesia = findViewById(R.id.Indonesia);
        Singapura = findViewById(R.id.Singapura);
        New_York = findViewById(R.id.New_York);
        Australia = findViewById(R.id.Australia);
        Belanda = findViewById(R.id.Belanda);
        Indonesia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashboardActivity.this, IndonesiaActivity.class));
            }
        });
        Singapura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashboardActivity.this, SingapuraActivity.class));
            }
        });
        New_York.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashboardActivity.this, NewYorkActivity.class));
            }
        });
        Australia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashboardActivity.this, AustraliaActivity.class));
            }
        });
        Belanda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashboardActivity.this, BelandaActivity.class));
            }
        });
    }
}
