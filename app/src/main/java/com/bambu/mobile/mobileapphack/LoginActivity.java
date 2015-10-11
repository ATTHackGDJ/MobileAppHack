package com.bambu.mobile.mobileapphack;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @Bind(R.id.login_button)
    View loginButton;
    @Bind(R.id.registrar)
    View registrarseBtn;
    @Bind(R.id.iniciar_secion)
    View iniciarBtn;
    @Bind(R.id.terminos_condiciones)
    View terminosBtn;
    @Bind(R.id.root_view)
    View rootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        final Animation animationFadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        loginButton.startAnimation(animationFadeIn);
        registrarseBtn.startAnimation(animationFadeIn);
        iniciarBtn.startAnimation(animationFadeIn);
        terminosBtn.startAnimation(animationFadeIn);

    }

    @OnClick(R.id.iniciar_secion)
    public void iniciarSecion() {
        startActivity(new Intent(LoginActivity.this, IniciarSecionActivity.class));
    }

}
