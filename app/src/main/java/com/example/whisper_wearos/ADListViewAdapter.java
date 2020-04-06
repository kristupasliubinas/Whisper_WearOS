package com.example.whisper_wearos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ADListViewAdapter extends ArrayAdapter<String> {

    Context context;
    String rTitle[];
    int rImgs[];

    public ADListViewAdapter(Context c, String title[], int imgs[]) {
        super(c, R.layout.row, R.id.actionText, title);
        this.context = c;
        this.rTitle = title;
        this.rImgs = imgs;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = layoutInflater.inflate(R.layout.row, parent, false);
        ImageView images = row.findViewById(R.id.actionImage);
        TextView myActionText = row.findViewById(R.id.actionText);

        // set resources on views
        images.setImageResource(rImgs[position]);
        myActionText.setText(rTitle[position]);

        return row;
    }
}
