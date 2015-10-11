package com.bambu.mobile.mobileapphack;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import java.util.List;

import butterknife.Bind;
import butterknife.BindColor;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class IntinerarioActivity extends AppCompatActivity {

    @Bind(R.id.collapsingToolbarLayout)
    public CollapsingToolbarLayout collapsingToolbarLayout;

    @Bind(R.id.card2)
    CardView cardView;

    @BindColor(R.color.accent)
    int colorResaltado;

    @Bind({R.id.icon1, R.id.icon2, R.id.icon3})
    public List<ImageView> icons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intinerario);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            int icon = extras.getInt("icon");
            if (icon != 0) {
                icons.get(0).setImageResource(icon);
                icons.get(1).setImageResource(icon);
                icons.get(2).setImageResource(icon);
            }
            int flag = extras.getInt("flag");
            if (flag == 1) {
                String timeArrive = extras.getString("timeLlegada");
                cardView.setBackgroundColor(colorResaltado);
                Snackbar.make(fab, "Evento encontrado a las " + timeArrive, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            } else if (flag == 2) {
                String timeArrive = extras.getString("timeLlegada");
                Snackbar.make(fab, "Saliste del evento " + timeArrive, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        }


        collapsingToolbarLayout.setTitle("Itinerario");


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @OnClick(R.id.card1)
    public void card1() {
        Intent intent = new Intent(IntinerarioActivity.this, DescriptionActivity.class);
        intent.putExtra("banner", R.mipmap.banner0);
        intent.putExtra("title", "Bruce Dickinson");
        startActivity(intent);
        overridePendingTransition(R.anim.slider_in_right, R.anim.slide_out_left);
    }

    @OnClick(R.id.card2)
    public void card2() {
        Intent intent = new Intent(IntinerarioActivity.this, DescriptionActivity.class);
        intent.putExtra("banner", R.mipmap.banner1);
        intent.putExtra("title", "Paul Zalcom");
        startActivity(intent);
        overridePendingTransition(R.anim.slider_in_right, R.anim.slide_out_left);
    }

    @OnClick(R.id.card3)
    public void card3() {
        Intent intent = new Intent(IntinerarioActivity.this, DescriptionActivity.class);
        intent.putExtra("banner", R.mipmap.banner2);
        intent.putExtra("title", "Eme Morato");
        startActivity(intent);
        overridePendingTransition(R.anim.slider_in_right, R.anim.slide_out_left);
    }


}
