package com.wintransit.nirmalpurohit.mymap;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class NewsFeed extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        TextView textView = findViewById(R.id.textViewNews);
        textView.setText("Stops on Ouellette Ave are now open from Erie to Wyandotte");
    }

}
