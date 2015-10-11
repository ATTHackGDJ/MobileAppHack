package com.bambu.mobile.mobileapphack;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class EventsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Events");

        Bundle extras = getIntent().getExtras();
        if (extras != null) {

        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }
        });

    }


    @OnClick(R.id.tierra)
    public void openTierraEvents() {
        Intent intent = new Intent(EventsActivity.this, IntinerarioActivity.class);
        intent.putExtra("icon", R.mipmap.tierra);
        startActivity(intent);
        overridePendingTransition(R.anim.slider_in_right, R.anim.slide_out_left);
    }

    @OnClick(R.id.marte)
    public void openMarteEvents() {
        Intent intent = new Intent(EventsActivity.this, IntinerarioActivity.class);
        intent.putExtra("icon", R.mipmap.marte);
        startActivity(intent);
        overridePendingTransition(R.anim.slider_in_right, R.anim.slide_out_left);
    }

}
