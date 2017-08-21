package yml.com.sunshine.activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import yml.com.sunshine.R;

public class SplashActivity extends AppCompatActivity {

    /*Usage of butterKnife library in android for binding the XML components*/

    private static final int SPLASH_TIMER = 3000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                startActivity(new Intent(SplashActivity.this, MovieActivity.class));

            }
        }, SPLASH_TIMER);


    }


}

