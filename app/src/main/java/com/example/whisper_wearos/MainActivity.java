package com.example.whisper_wearos;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.activity.ConfirmationActivity;
import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.widget.Button;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;


public class MainActivity extends WearableActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get access to views defined in layout
        Button notificationButton = findViewById(R.id.notificationButton);
        Button browseButton = findViewById(R.id.browseButton);

        //specify what happens when notificationButton is pressed
        notificationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNotification();

                // Display confirmation animation
                Intent intent = new Intent(v.getContext(), ConfirmationActivity.class);
                intent.putExtra(ConfirmationActivity.EXTRA_ANIMATION_TYPE, ConfirmationActivity.SUCCESS_ANIMATION);
                intent.putExtra(ConfirmationActivity.EXTRA_MESSAGE, "Replies received. Check notifications!");
                startActivity(intent);
            }
        });

        //specify what happens when browseButton is pressed
        browseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), GeneralContentActivity.class);
                startActivity(intent);
            }
        });
    }

    private void addNotification () {
        //build the notification
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_whisper)
                .setContentTitle("Anonymous replied:")
                .setContentText("I study for exams 📚");

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
