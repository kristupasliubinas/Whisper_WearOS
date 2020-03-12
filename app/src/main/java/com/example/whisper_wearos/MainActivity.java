package com.example.whisper_wearos;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;


public class MainActivity extends WearableActivity {

    private Button notificationButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get access to views defined in layout
        notificationButton = findViewById(R.id.notificationButton);

        //specify what happens when notificationButton is pressed
        notificationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNotification();
            }
        });
    }

    private void addNotification () {
        //build the notification
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("squidward replied:")
                .setContentText("I love going to the gym!!");

        //create the intent for the Reply Activity
        Intent notificationIntent = new Intent(this, ReplyActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this,0, notificationIntent, 0);

        //set the intent that will fire when the user taps the notification
        notificationBuilder.setContentIntent(contentIntent).setAutoCancel(true); //automatically removes the notification when the user taps it

        //add a notification
        NotificationManagerCompat manager = NotificationManagerCompat.from(this);
        manager.notify(0, notificationBuilder.build());
    }
}
