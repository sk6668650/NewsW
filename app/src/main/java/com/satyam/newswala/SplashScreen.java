package com.satyam.newswala;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity
{
    Animation animation;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        textView = findViewById(R.id.splashText);
        animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadein);
        textView.setAnimation(animation);
        // hide statusBar

        View view = getWindow().getDecorView();
        int ui = View.SYSTEM_UI_FLAG_FULLSCREEN;
        view.setSystemUiVisibility(ui);

        // hide actionBar for one activity

        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                Intent i = new Intent(SplashScreen.this,MainActivity.class);
                startActivity(i);

                finish();

            }
        },2000);
    }
}
