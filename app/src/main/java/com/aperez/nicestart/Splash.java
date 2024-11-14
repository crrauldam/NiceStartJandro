package com.aperez.nicestart;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieDrawable;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);

        openApp();

        ImageView logosplash = findViewById(R.id.logosplash);
        Animation myanim = AnimationUtils.loadAnimation(this, R.anim.logo);
        logosplash.startAnimation(myanim);

        ConstraintLayout fondosplash = findViewById(R.id.main);
        Animation myanim1 = AnimationUtils.loadAnimation(this, R.anim.fondo);
        fondosplash.startAnimation(myanim1);

        TextView nicestartsplash = findViewById(R.id.textView2);
        Animation myanim2 = AnimationUtils.loadAnimation(this, R.anim.nicestart);
        nicestartsplash.startAnimation(myanim2);

        ConstraintLayout layout = findViewById(R.id.lay);
        Animation myanim3 = AnimationUtils.loadAnimation(this, R.anim.ampliacion);
        layout.startAnimation(myanim3);





        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void openApp() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable()
        {
            @Override
            public void run() {
                Intent intent = new Intent (Splash.this, Login.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        }, 2900);
    }
}