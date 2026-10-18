package com.example.kalend_aral;

import android.content.Context;
import android.content.SharedPreferences;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class EventStorage {

    private static final String PREFS_NAME = "KalendAralEvents";
    private static final String EVENTS_KEY = "events";

    public static void saveEvent(
            Context context,
            String name,
            String date,
            String time,
            String location,
            String description) {

        SharedPreferences prefs = context.getSharedPreferences(
                PREFS_NAME, Context.MODE_PRIVATE
        );

        JSONArray events;

        try {
            events = new JSONArray(
                    prefs.getString(EVENTS_KEY, "[]")
            );

            JSONObject event = new JSONObject();
            event.put("name", name);
            event.put("date", date);
            event.put("time", time);
            event.put("location", location);
            event.put("description", description);

            events.put(event);

            prefs.edit()
                    .putString(EVENTS_KEY, events.toString())
                    .apply();

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static JSONArray getEvents(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(
                PREFS_NAME, Context.MODE_PRIVATE
        );

        try {
            return new JSONArray(
                    prefs.getString(EVENTS_KEY, "[]")
            );
        } catch (JSONException e) {
            return new JSONArray();
        }
    }
}