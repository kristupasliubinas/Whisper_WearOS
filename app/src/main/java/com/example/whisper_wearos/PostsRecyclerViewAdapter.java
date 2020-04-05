package com.example.whisper_wearos;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class PostsRecyclerViewAdapter extends RecyclerView.Adapter<PostsRecyclerViewAdapter.MyViewHolder> {

    private PostsRecyclerViewData[] postsDataset;

    // constructor
    public PostsRecyclerViewAdapter(PostsRecyclerViewData[] postsDataset) {
        this.postsDataset = postsDataset;
    }


    // override the tree required methods
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View whisperPost = layoutInflater.inflate(R.layout.whisper_post, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(whisperPost);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.userId.setText(postsDataset[position].getUserId());
        holder.whisper.setText(postsDataset[position].getWhisper());

        // if I wanted to specify an action when a post gets clicked
        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // specify what happens when a post gets clicked
                openActionDrawer(v);
            }
        });
    }

    @Override
    public int getItemCount() {
        return postsDataset.length;
    }


    // create the ViewHolder class
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public ConstraintLayout constraintLayout;
        public TextView userId;
        public TextView whisper;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            constraintLayout = itemView.findViewById(R.id.constraintLayout);
            this.userId = itemView.findViewById(R.id.userId);
            this.whisper = itemView.findViewById(R.id.messageTextView);
        }
    }


    // the Adapter class is now complete

    // methods for additional functionality in this class go here

    // launch the Action Drawer activity
    public void openActionDrawer (View v) {
        Intent intent = new Intent(v.getContext(), ActionDrawerActivity.class);
        v.getContext().startActivity(intent);
    }

}
