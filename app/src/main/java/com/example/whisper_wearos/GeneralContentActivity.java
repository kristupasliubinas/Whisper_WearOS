package com.example.whisper_wearos;

import android.graphics.Color;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

public class GeneralContentActivity extends WearableActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reply_v3);


        // RECYCLERVIEW FUNCTIONALITY

        // create the array of items for posts
        PostsRecyclerViewData[] posts = new PostsRecyclerViewData[] {
                new PostsRecyclerViewData("Anon", "People who win the lottery are the most fortunate lucky people on earth"),
                new PostsRecyclerViewData("Zombie_skies", "Left the mic on while eating during a conference call🤦🏼‍♀️"),
                new PostsRecyclerViewData("Anonymous", "I love that there are certain vegan foods nobody will buy in the supermarket so then I always have my essential oat milk, butter, cheese, mayo, etc"),
                new PostsRecyclerViewData("Unholy Saint", "Just found out I have a secret admirer, and that made my day."),
                new PostsRecyclerViewData("Blue Bird", "An exes greeting is more awkward than a strangers"),
                new PostsRecyclerViewData("glass_under", "I'm saving a ton of money on my water bill. I haven't showered since the start of quarantine. Sadly the dog avoids me though.")
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


        // SET BACKGROUND TO A DIFFERENT COLOUR FOR GENERAL CONTENT VIEW

        ConstraintLayout cl = findViewById(R.id.postsLayout);
        cl.setBackgroundColor(Color.rgb(76, 11, 33));
    }
}
