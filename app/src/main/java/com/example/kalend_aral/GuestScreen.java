package com.example.kalend_aral;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GuestScreen extends AppCompatActivity {

    private LinearLayout eventList;
    private EditText searchEvents;
    private JSONArray events;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_screen);

        eventList = findViewById(R.id.eventList);
        searchEvents = findViewById(R.id.searchEvents);

        searchEvents.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(
                    CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(
                    CharSequence s, int start, int before, int count) {
                displayEvents(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        events = EventStorage.getEvents(this);
        displayEvents(searchEvents == null
                ? ""
                : searchEvents.getText().toString());
    }

    private void displayEvents(String keyword) {
        eventList.removeAllViews();

        if (events == null) {
            events = EventStorage.getEvents(this);
        }

        String search = keyword.trim().toLowerCase();
        int matchCount = 0;

        for (int i = 0; i < events.length(); i++) {
            try {
                JSONObject event = events.getJSONObject(i);

                String name = event.optString("name");
                String date = event.optString("date");
                String time = event.optString("time");
                String location = event.optString("location");
                String description = event.optString("description");

                String searchableText = (
                        name + " " + date + " " + time + " "
                                + location + " " + description
                ).toLowerCase();

                if (!searchableText.contains(search)) {
                    continue;
                }

                TextView eventCard = new TextView(this);

                eventCard.setText(
                        name + "\n"
                                + "Date: " + date + "\n"
                                + "Time: " + time + "\n"
                                + "Location: " + location
                                + (description.isEmpty()
                                ? ""
                                : "\nDescription: " + description)
                );

                eventCard.setTextSize(16);
                eventCard.setTextColor(0xFF234A73);
                eventCard.setBackgroundColor(0xFFFFFFFF);
                eventCard.setPadding(24, 24, 24, 24);

                LinearLayout.LayoutParams params =
                        new LinearLayout.LayoutParams(
                                ViewGroup.LayoutParams.MATCH_PARENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT
                        );

                params.setMargins(0, 0, 0, 16);
                eventList.addView(eventCard, params);

                matchCount++;

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        if (matchCount == 0) {
            TextView emptyMessage = new TextView(this);

            if (events.length() == 0) {
                emptyMessage.setText("No upcoming events yet.");
            } else {
                emptyMessage.setText("No events match your search.");
            }

            emptyMessage.setTextSize(16);
            emptyMessage.setTextColor(0xFF64748B);
            emptyMessage.setPadding(4, 12, 4, 12);

            eventList.addView(emptyMessage);
        }
    }
}