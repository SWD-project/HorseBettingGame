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

    Handler raceHandler = new Handler();

    Random random = new Random();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);


        bind();
        startGame();

    }


    private void bind() {
        horse1 = findViewById(R.id.seekBarHorse1);
        horse2 = findViewById(R.id.seekBarHorse2);
        horse3 = findViewById(R.id.seekBarHorse3);
        horse4 = findViewById(R.id.seekBarHorse4);
    }

    private void startGame() {
        raceHandler.postDelayed(() -> {
            int horse1Progress = horse1.getProgress();
            int horse2Progress = horse2.getProgress();
            int horse3Progress = horse3.getProgress();
            int horse4Progress = horse4.getProgress();

            int change1 = random.nextInt(10);
            int change2 = random.nextInt(10);
            int change3 = random.nextInt(10);
            int change4 = random.nextInt(10);

            horse1.setProgress(horse1Progress + change1);
            horse2.setProgress(horse2Progress + change2);
            horse3.setProgress(horse3Progress + change3);
            horse4.setProgress(horse4Progress + change4);

            if (horse1Progress == 1000 || horse2Progress == 1000 || horse3Progress == 1000 || horse4Progress == 1000) {
            } else {
                startGame();
            }

        }, 100);
    }
}