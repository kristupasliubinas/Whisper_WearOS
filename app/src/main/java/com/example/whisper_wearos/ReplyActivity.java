package com.example.whisper_wearos;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.wearable.activity.WearableActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import java.util.List;

public class ReplyActivity extends WearableActivity {

//    // fields for the action drawer functionality - OG
//    private ListView listView;
//    String mTitle[] = {"Like", "Reply", "Chat"};
//    int images[] = {R.drawable.ic_m_white_48dp, R.drawable.ic_m_white_48dp, R.drawable.ic_m_white_48dp};

//    // fields for V4
//    private WearableActionDrawerView wearableActionDrawer;


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




//        // ACTION DRAWER FUNCTIONALITY - OG
//
//        listView = findViewById(R.id.actionDrawer);
//
//        // create an adapter class --> MyAdapter.java
//
//        MyAdapter adapter = new MyAdapter(this, mTitle, images);
//        // pass the adapter to the ListView
//        listView.setAdapter(adapter);
//
//        // set item click on list view
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                if (position == 0) {
//                    Toast.makeText(ReplyActivity.this, "Liked", Toast.LENGTH_SHORT).show();
//                }
//                if (position == 1) {
////                    Toast.makeText(ReplyActivity.this, "You have replied", Toast.LENGTH_SHORT).show();
//                    displaySpeechRecognizer();
//                }
//                if (position == 2) {
//                    Toast.makeText(ReplyActivity.this, "Start a chat", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });


//        // ACTION DRAWER FUNCTIONALITY - V4
//
//        wearableActionDrawer = findViewById(R.id.bottom_action_drawer);
//        // Peeks action drawer on the bottom.
//        wearableActionDrawer.getController().peekDrawer();
////        wearableActionDrawer.setOnMenuItemClickListener(this);
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
        }
    }
}
