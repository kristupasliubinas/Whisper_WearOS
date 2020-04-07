package com.example.whisper_wearos;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class ActionDrawerActivity extends WearableActivity {

    private ListView listView;
    String mTitle[] = {"Like", "Reply", "View Replies" ,"Flag Whisper"};
    int images[] = {R.drawable.ic_m_white_48dp, R.drawable.ic_m_white_48dp, R.drawable.ic_m_white_48dp, R.drawable.ic_m_white_48dp};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_drawer);

        // ACTION DRAWER FUNCTIONALITY

        listView = findViewById(R.id.actionDrawer);

        // create an adapter class --> ADListViewAdapter.java

        ADListViewAdapter adapter = new ADListViewAdapter(this, mTitle, images);
        // pass the adapter to the ListView
        listView.setAdapter(adapter);

        // set item click on list view
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Toast.makeText(ActionDrawerActivity.this, "Liked", Toast.LENGTH_SHORT).show();
                }
                if (position == 1) {
                    displaySpeechRecognizer();
                }
                if (position == 2) {
                    openFurtherReplies();
                }
                if (position == 3) {
                    Toast.makeText(ActionDrawerActivity.this, "Flagged as inappropriate", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // METHODS TO ENABLE SPEECH INPUT FOR REPLY FUNCTIONALITY

    public void displaySpeechRecognizer() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "What is the title?");
        // Start the activity, the intent will be populated with the speech text
        startActivityForResult(intent, 1001);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 1001 && resultCode == RESULT_OK) {
            List<String> results = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);

            String spokenText = results.get(0);

            Toast.makeText(ActionDrawerActivity.this, "Reply posted", Toast.LENGTH_SHORT).show();
        }
    }

    // METHODS FOR VIEWING FURTHER REPLIES

    public void openFurtherReplies () {
        Intent intent = new Intent(this, FurtherRepliesActivity.class);
        startActivity(intent);
    }
}
