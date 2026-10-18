package com.example.kalend_aral;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AdminPanel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_panel);

        EditText etName = findViewById(R.id.etEventName);
        EditText etDate = findViewById(R.id.etEventDate);
        EditText etTime = findViewById(R.id.etEventTime);
        EditText etLocation = findViewById(R.id.etEventLocation);
        EditText etDescription = findViewById(R.id.etEventDescription);

        Button btnSave = findViewById(R.id.btnSaveEvent);

        btnSave.setOnClickListener(v -> {

            String name = etName.getText().toString().trim();
            String date = etDate.getText().toString().trim();
            String time = etTime.getText().toString().trim();
            String location = etLocation.getText().toString().trim();
            String description =
                    etDescription.getText().toString().trim();

            if (name.isEmpty() || date.isEmpty()
                    || time.isEmpty() || location.isEmpty()) {

                Toast.makeText(
                        this,
                        "Please fill in the event name, date, time, and location.",
                        Toast.LENGTH_SHORT
                ).show();

                return;
            }

            EventStorage.saveEvent(
                    this, name, date, time, location, description
            );

            Toast.makeText(
                    this,
                    "Event saved successfully!",
                    Toast.LENGTH_SHORT
            ).show();

            etName.setText("");
            etDate.setText("");
            etTime.setText("");
            etLocation.setText("");
            etDescription.setText("");
        });
    }
}
