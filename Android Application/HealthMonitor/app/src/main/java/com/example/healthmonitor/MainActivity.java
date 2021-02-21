package com.example.healthmonitor;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private static final int SPLASH_SCREEN = 3000;
    private Window mWindow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWindow = getWindow();
        mWindow.getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
              Intent intent=new Intent(MainActivity.this,Login.class);
             startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);
    }


}


