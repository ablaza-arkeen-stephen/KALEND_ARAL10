package com.example.kalend_aral;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_screen);

        ViewCompat.setOnApplyWindowInsetsListener(
                findViewById(R.id.main), (v, insets) -> {
                    Insets systemBars = insets.getInsets(
                            WindowInsetsCompat.Type.systemBars()
                    );

                    v.setPadding(
                            systemBars.left,
                            systemBars.top,
                            systemBars.right,
                            systemBars.bottom
                    );

                    return insets;
                }
        );

        Button btnAdmin = findViewById(R.id.btnAdmin);
        Button btnGuest = findViewById(R.id.btnGuest);
        Button btnAbout = findViewById(R.id.btnAbout);

        btnAdmin.setOnClickListener(v -> {
            Intent intent = new Intent(
                    LoginScreen.this, AdminPanel.class
            );
            startActivity(intent);
        });

        btnGuest.setOnClickListener(v -> {
            Intent intent = new Intent(
                    LoginScreen.this, GuestScreen.class
            );
            startActivity(intent);
        });

        btnAbout.setOnClickListener(v -> {
            Intent intent = new Intent(
                    LoginScreen.this, AboutApp.class
            );
            startActivity(intent);
        });
    }
}