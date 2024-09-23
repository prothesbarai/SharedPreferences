package com.prothes.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class SplashScreen extends AppCompatActivity {
    private LottieAnimationView animationView1,animationView2,animationView3;
    private TextView txt;
    private Typeface typeface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P){
            WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
            layoutParams.layoutInDisplayCutoutMode = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES;
            getWindow().setAttributes(layoutParams);
        }
        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        );
        setContentView(R.layout.splash_screen);

        txt = findViewById(R.id.txt);
        typeface = Typeface.createFromAsset(getAssets(),"fonts/phola.otf");
        txt.setTypeface(typeface);



        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                startProgress();
                goToHomePage();
            }
        });
        thread.start();



    }

    public void startProgress(){
        try {
            Thread.sleep(4250,900);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void goToHomePage(){
        startActivity(new Intent(SplashScreen.this,MainActivity.class));
        finish();
    }
}