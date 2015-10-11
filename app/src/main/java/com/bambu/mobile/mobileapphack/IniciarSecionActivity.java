package com.bambu.mobile.mobileapphack;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class IniciarSecionActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    public Toolbar toolbar;

    @Bind(R.id.collapsingToolbarLayout)
    public CollapsingToolbarLayout collapsingToolbarLayout;

    @Bind(R.id.select)
    public TextView textViewSelector;

    @Bind(R.id.text_title)
    public TextView textTitle;

    @Bind(R.id.banner)
    public ImageView imageBanner;

    @Bind(R.id.login_layout_email)
    public TextInputLayout layoutEmail;


    @Bind(R.id.login_input_email)
    public EditText inputEmail;

    @Bind(R.id.login_layout_pass)
    public TextInputLayout layoutPass;

    @Bind(R.id.login_input_pass)
    public EditText inputPass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_secion);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        Animation bounceInAnimation = AnimationUtils.loadAnimation(IniciarSecionActivity.this, R.anim.bounce_in);
        imageBanner.startAnimation(bounceInAnimation);
        textTitle.startAnimation(bounceInAnimation);
        textViewSelector.startAnimation(bounceInAnimation);
        collapsingToolbarLayout.setTitle("Bienvenido");

    }

    @OnClick(R.id.btn_login)
    public void login() {
        startActivity(new Intent(IniciarSecionActivity.this, MainActivity.class));
    }

}
