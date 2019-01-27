package com.example.lolaabudu.notificationlist_recyclerview;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lolaabudu.notificationlist_recyclerview.model.NotificationThings;

public class SecondActivity extends AppCompatActivity {

    private TextView textView;
    private ImageView imageView;
    private Button notificationButton;
    private SharedPreferences sharedPreferences;
    private NotificationManager notificationManager;
    private final int NOTIFICATION_ID = 0;
    private static final String SHARED_PREFS_KEY = "com.example.lolaabudu.sharedpreferences2";
    private static final String PRIMARY_CHANNEL_ID = "primary_notification_channel";
    private static final String ACTION_UPDATE_NOTIFICATION =
            "com.example.android.notificationlist.ACTION_UPDATE_NOTIFICATION";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        NotificationThings notificationThings = getIntent().getParcelableExtra("things");

        textView = findViewById(R.id.description_textView_secondActivity);
        imageView = findViewById(R.id.photo_imageView_secondActivity);
        notificationButton = findViewById(R.id.notification_button_secondActivity);
        sharedPreferences = getSharedPreferences(SHARED_PREFS_KEY, MODE_PRIVATE);

        textView.setText(notificationThings.getDescription());
        Log.d("inView", "text: " + notificationThings.getDescription());

        imageView.setImageDrawable(getResources().getDrawable(notificationThings.getItem()));
        Log.d("inView", "image: " + notificationThings.getItem());

        notificationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sharedPreferences.contains(textView.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "Notification: '" + textView.getText() + "' has already been sent!", Toast.LENGTH_SHORT).show();
                } else {
                    sendNotification();
                }
            }
        });
        createNotificationChannel();
    }

    private void sendNotification() {
        NotificationCompat.Builder notifyBuilder = getNotificationBuilder();
        notificationManager.notify(NOTIFICATION_ID, notifyBuilder.build());
        Intent notifyIntent = new Intent(ACTION_UPDATE_NOTIFICATION);
        PendingIntent updatePendingIntent = PendingIntent.getBroadcast(this, NOTIFICATION_ID, notifyIntent, PendingIntent.FLAG_ONE_SHOT);
        notifyBuilder.addAction(R.drawable.ic_action_airplane, "Update Notification", updatePendingIntent);
        Log.d("Notify", "It works");

        //using shared preference to save the one instance of sending the notification, then send a Toast if the notification has already been sent
        sharedPreferences.edit().putBoolean(textView.getText().toString(), true).apply();
    }

    private NotificationCompat.Builder getNotificationBuilder() {
        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent notificationPendingIntent = PendingIntent.getActivity(this,
                NOTIFICATION_ID, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder notifyBuilder = new NotificationCompat.Builder(this, PRIMARY_CHANNEL_ID)
                .setContentTitle("Notification Things notification.")
                .setContentText("Click Me!")
                .setSmallIcon(R.drawable.ic_action_airplane)
                .setContentIntent(notificationPendingIntent)
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setDefaults(NotificationCompat.DEFAULT_ALL);
        return notifyBuilder;
    }

    private void createNotificationChannel() {
        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (android.os.Build.VERSION.SDK_INT >=
                android.os.Build.VERSION_CODES.O) {

            NotificationChannel notificationChannel = new NotificationChannel(PRIMARY_CHANNEL_ID,
                    "Create Notification", NotificationManager
                    .IMPORTANCE_HIGH);
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.enableVibration(true);
            notificationChannel.setDescription("Notification from Notification List");
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }
}

