package com.wintransit.nirmalpurohit.mymap;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

public class BusListActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_list);


        CardView cardView = findViewById(R.id.oneC);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BusListActivity.this, InformationActivity.class);
                intent.putExtra("Bus_name", "1C");
                startActivity(intent);
            }
        });

        cardView = findViewById(R.id.oneA);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BusListActivity.this, InformationActivity.class);
                intent.putExtra("Bus_name", "1A");
                startActivity(intent);
            }
        });

        cardView = findViewById(R.id.two);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BusListActivity.this, InformationActivity.class);
                intent.putExtra("Bus_name", "2");
                startActivity(intent);
            }
        });

        cardView = findViewById(R.id.three);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BusListActivity.this, InformationActivity.class);
                intent.putExtra("Bus_name", "3");
                startActivity(intent);
            }
        });

        cardView = findViewById(R.id.four);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BusListActivity.this, InformationActivity.class);
                intent.putExtra("Bus_name", "4");
                startActivity(intent);
            }
        });

        cardView = findViewById(R.id.five);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BusListActivity.this, InformationActivity.class);
                intent.putExtra("Bus_name", "5");
                startActivity(intent);
            }
        });

        cardView = findViewById(R.id.six);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BusListActivity.this, InformationActivity.class);
                intent.putExtra("Bus_name", "6");
                startActivity(intent);
            }
        });

        cardView = findViewById(R.id.fourteen);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BusListActivity.this, InformationActivity.class);
                intent.putExtra("Bus_name", "14");
                startActivity(intent);
            }
        });

    }
}
