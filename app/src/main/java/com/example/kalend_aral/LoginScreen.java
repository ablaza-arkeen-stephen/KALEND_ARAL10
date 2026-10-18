package com.example.kalend_aral;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class LoginScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        Button btnGuest = findViewById(R.id.btnGuest);
        Button btnAdmin = findViewById(R.id.btnAdmin);
        Button btnAbout = findViewById(R.id.btnAbout);

        btnGuest.setOnClickListener(v -> {
            Intent intent = new Intent(LoginScreen.this, GuestScreen.class);
            startActivity(intent);
        });

        btnAdmin.setOnClickListener(v -> {
            Intent intent = new Intent(LoginScreen.this, AdminPanel.class);
            startActivity(intent);
        });

        btnAbout.setOnClickListener(v -> {
            Intent intent = new Intent(LoginScreen.this, AboutApp.class);
            startActivity(intent);
        });
    }
}
