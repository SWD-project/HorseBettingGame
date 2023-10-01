package com.example.horsebetting;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.SeekBar;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class GameActivity extends AppCompatActivity {
    Button raceButton;
    SeekBar horse1;
    SeekBar horse2;
    SeekBar horse3;
    SeekBar horse4;

    int horse1BaseSpeed;
    int horse2BaseSpeed;
    int horse3BaseSpeed;
    int horse4BaseSpeed;

    Handler raceHandler = new Handler();

    Random random = new Random();

    public static final String SHARED_PREFS = "shared_prefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);


        bind();
        startGame();

    }


    private void bind() {
        horse1 = findViewById(R.id.seekBarHorse1);
        horse1.setEnabled(false);
        horse2 = findViewById(R.id.seekBarHorse2);
        horse2.setEnabled(false);
        horse3 = findViewById(R.id.seekBarHorse3);
        horse3.setEnabled(false);
        horse4 = findViewById(R.id.seekBarHorse4);
        horse4.setEnabled(false);
    }

    private void startGame() {
        raceHandler.postDelayed(() -> {
            int horse1Progress = horse1.getProgress();
            int horse2Progress = horse2.getProgress();
            int horse3Progress = horse3.getProgress();
            int horse4Progress = horse4.getProgress();

            horse1BaseSpeed = random.nextInt(5);
            horse2BaseSpeed = random.nextInt(5);
            horse3BaseSpeed = random.nextInt(5);
            horse4BaseSpeed = random.nextInt(5);


            int change1 = horse1BaseSpeed + random.nextInt(10);
            int change2 = horse2BaseSpeed + random.nextInt(10);
            int change3 = horse3BaseSpeed + random.nextInt(10);
            int change4 = horse4BaseSpeed + random.nextInt(10);

            horse1.setProgress(horse1Progress + change1);
            horse2.setProgress(horse2Progress + change2);
            horse3.setProgress(horse3Progress + change3);
            horse4.setProgress(horse4Progress + change4);

            if (horse1Progress == 1000 || horse2Progress == 1000 || horse3Progress == 1000 || horse4Progress == 1000) {
                return;
            } else {
                startGame();
            }

        }, 100);
    }
}