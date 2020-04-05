package com.example.whisper_wearos;

import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class ActionDrawerActivity extends WearableActivity {

    private ListView listView;
    String mTitle[] = {"Like", "Reply", "Chat"};
    int images[] = {R.drawable.ic_m_white_48dp, R.drawable.ic_m_white_48dp, R.drawable.ic_m_white_48dp};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_drawer);

        listView = findViewById(R.id.actionDrawer);

        // create an adapter class --> MyAdapter.java

        MyAdapter adapter = new MyAdapter(this, mTitle, images);
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
                    Toast.makeText(ActionDrawerActivity.this, "You have replied", Toast.LENGTH_SHORT).show();
//                    displaySpeechRecognizer();
                }
                if (position == 2) {
                    Toast.makeText(ActionDrawerActivity.this, "Start a chat", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
