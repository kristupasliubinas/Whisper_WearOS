package com.example.whisper_wearos;

import android.graphics.Color;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

public class FurtherRepliesActivity extends WearableActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reply_v3);


        // RECYCLERVIEW FUNCTIONALITY

        // create the array of items for posts
        PostsRecyclerViewData[] posts = new PostsRecyclerViewData[] {
                new PostsRecyclerViewData("Obsessed", "Tiger King all day. It's crazy!!"),
                new PostsRecyclerViewData("gollum", "Netflix is too expensive for me :("),
                new PostsRecyclerViewData("old_school", "Get a life!"),
                new PostsRecyclerViewData("TVLover", "I think I've watched everything on there by now...")
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


        // SET BACKGROUND TO A DIFFERENT COLOUR FOR FURTHER REPLIES

        ConstraintLayout cl = findViewById(R.id.postsLayout);
        cl.setBackgroundColor(Color.rgb(0, 20, 40));
    }
}
