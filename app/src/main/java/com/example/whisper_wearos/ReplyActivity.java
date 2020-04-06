package com.example.whisper_wearos;

import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

public class ReplyActivity extends WearableActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reply_v3);


        // RECYCLERVIEW FUNCTIONALITY

        // create the array of items for posts
        PostsRecyclerViewData[] posts = new PostsRecyclerViewData[] {
              new PostsRecyclerViewData("Anonymous", "I study for exams"),
                new PostsRecyclerViewData("anon", "Cleaning the house"),
                new PostsRecyclerViewData("Secret", "Watch Netflix!"),
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
    }
}
