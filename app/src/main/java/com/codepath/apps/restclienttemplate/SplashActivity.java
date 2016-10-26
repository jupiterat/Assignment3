package com.codepath.apps.restclienttemplate;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by dtathoai on 26/10/2016.
 */

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (TwitterApplication.getRestClient().isAuthenticated()) {
                    startHome();
                } else {
                    startLogin();
                }
                finish();
            }
        }, 2000);

    }

    @Override
    public void onBackPressed() {

    }

    public void startHome() {
        Intent i = new Intent(this, HomeActivity.class);
        startActivity(i);
    }

    public void startLogin() {
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
    }
}
