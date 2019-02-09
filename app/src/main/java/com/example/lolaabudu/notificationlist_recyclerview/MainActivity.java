package com.example.lolaabudu.notificationlist_recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lolaabudu.notificationlist_recyclerview.controller.NotificationThingsAdapter;
import com.example.lolaabudu.notificationlist_recyclerview.model.NotificationThings;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView notificationThingsView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationThingsView = findViewById(R.id.notification_list_recyclerView);

        List<NotificationThings> notificationItems = createList();

        NotificationThingsAdapter notificationThingsAdapter = new NotificationThingsAdapter(notificationItems);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        notificationThingsView.setAdapter(notificationThingsAdapter);
        notificationThingsView.setLayoutManager(linearLayoutManager);
    }

    //things like this should be extracted to a method to help clean up the code
    private List<NotificationThings> createList() {
        List<NotificationThings> notificationItems = new ArrayList<>();

        notificationItems.add(new NotificationThings(R.drawable.ic_airplanemode, "This is an airplane"));
        notificationItems.add(new NotificationThings(R.drawable.ic_bike, "This is a bike"));
        notificationItems.add(new NotificationThings(R.drawable.ic_battery_alert, "This is a dying battery"));
        notificationItems.add(new NotificationThings(R.drawable.ic_battery_full, "This is a full battery"));
        notificationItems.add(new NotificationThings(R.drawable.ic_arrow_upward, "This is an upward arrow"));
        notificationItems.add(new NotificationThings(R.drawable.ic_arrow_downward, "This is a downward arrow"));
        notificationItems.add(new NotificationThings(R.drawable.ic_arrow_forward, "This is a forward arrow"));
        notificationItems.add(new NotificationThings(R.drawable.ic_arrow_back, "This is a backward arrow"));
        notificationItems.add(new NotificationThings(R.drawable.ic_full_moon, "This is a full moon"));
        notificationItems.add(new NotificationThings(R.drawable.ic_half_moon, "This is a half moon"));
        notificationItems.add(new NotificationThings(R.drawable.ic_key, "This is a key"));
        notificationItems.add(new NotificationThings(R.drawable.ic_music_note, "This is a music sign"));
        notificationItems.add(new NotificationThings(R.drawable.ic_phonecall, "This is a phone call"));
        notificationItems.add(new NotificationThings(R.drawable.ic_power_plug, "This is a power plug"));
        notificationItems.add(new NotificationThings(R.drawable.ic_shopping_cart, "This is a shopping cart"));
        notificationItems.add(new NotificationThings(R.drawable.ic_text_message, "This is a text message"));
        notificationItems.add(new NotificationThings(R.drawable.ic_voicemail, "This is a voicemail"));
        notificationItems.add(new NotificationThings(R.drawable.ic_wifi, "This is a wifi"));
        notificationItems.add(new NotificationThings(R.drawable.ic_zoom_in, "This is a zoom-in"));
        notificationItems.add(new NotificationThings(R.drawable.ic_zoom_out, "This is a zoom-out"));

        return notificationItems;
    }
}

