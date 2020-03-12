package com.example.whisper_wearos;

import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.widget.TextView;

public class ReplyActivity extends WearableActivity {

    private TextView messageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reply);

        //get access to views defined in layout
        messageTextView = findViewById(R.id.messageTextView);
    }
}
