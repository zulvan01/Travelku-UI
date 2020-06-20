package com.dicoding.assosiate.travelku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class SignInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        findViewById(R.id.textForgotPassword).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ForgotPasswordActivity.class));
            }
        });
    }
    public void btn_signIn(View view) {
        startActivity(new Intent(getApplicationContext(), DashboardActivity.class));

    }
}
