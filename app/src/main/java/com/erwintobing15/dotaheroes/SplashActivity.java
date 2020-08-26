package com.erwintobing15.dotaheroes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // 2 second loading screen
        int loading_time = 2000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                // loading screen  3 second then start MainActivity
                Intent home = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(home);
                finish();

            }
        }, loading_time);
    }
}