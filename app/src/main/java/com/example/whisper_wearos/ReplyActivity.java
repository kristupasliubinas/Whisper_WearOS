package com.example.whisper_wearos;

import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

public class ReplyActivity extends WearableActivity {

    // fields for the action drawer functionality
    private ListView listView;
    String mTitle[] = {"Like", "Reply", "Chat"};
    int images[] = {R.drawable.ic_m_white_48dp, R.drawable.ic_m_white_48dp, R.drawable.ic_m_white_48dp};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reply3);


        // RECYCLERVIEW FUNCTIONALITY

        // create the array of items for posts
        PostsRecyclerViewData[] posts = new PostsRecyclerViewData[] {
              new PostsRecyclerViewData("SpongeBob", "I love jellyfish!"),
                new PostsRecyclerViewData("Patrick Star", "leedle leedle leedle"),
                new PostsRecyclerViewData("Squidward", "I hate my life..."),
        };

        // set the RecyclerView, set the Layout Manager and attach the adapter to the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.postsRecyclerView);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        PostsRecyclerViewAdapter recyclerViewAdapter = new PostsRecyclerViewAdapter(posts);
        recyclerView.setAdapter(recyclerViewAdapter);

        // use the PagerSnapHelper class to snap pages to the screen and achieve paging functionality
        SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);




        // ACTION DRAWER FUNCTIONALITY

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
