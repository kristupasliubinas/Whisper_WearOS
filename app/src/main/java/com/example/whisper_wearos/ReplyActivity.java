package com.example.whisper_wearos;

import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.wear.widget.drawer.WearableDrawerView;

public class ReplyActivity extends WearableActivity {

    private ListView listView;
    String mTitle[] = {"Like", "Reply", "Chat"};
    int images[] = {R.drawable.ic_m_white_48dp, R.drawable.ic_m_white_48dp, R.drawable.ic_m_white_48dp};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reply3);

        listView = findViewById(R.id.actionDrawer);

        // create an adapter class --> MyAdapter.java

        MyAdapter adapter = new MyAdapter(this, mTitle, images);
        listView.setAdapter(adapter);

        // set item click on list view
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Toast.makeText(ReplyActivity.this, "You have liked", Toast.LENGTH_SHORT).show();
                }
                if (position == 1) {
                    Toast.makeText(ReplyActivity.this, "You have replied", Toast.LENGTH_SHORT).show();
                }
                if (position == 2) {
                    Toast.makeText(ReplyActivity.this, "Start a chat", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
