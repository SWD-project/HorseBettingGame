package com.example.horsebetting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

import com.example.horsebetting.entity.Game;
import com.example.horsebetting.entity.UserManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameActivity extends AppCompatActivity {
    Button startGameButton;
    SeekBar horse1;
    SeekBar horse2;
    SeekBar horse3;
    SeekBar horse4;
    SeekBar horse5;

    EditText editTextBetHorse1;
    EditText editTextBetHorse2;
    EditText editTextBetHorse3;
    EditText editTextBetHorse4;
    EditText editTextBetHorse5;

    int horse1BaseSpeed;
    int horse2BaseSpeed;
    int horse3BaseSpeed;
    int horse4BaseSpeed;
    int horse5BaseSpeed;

    Handler raceHandler = new Handler();

    Random random = new Random();
    private UserManagement userManagement = UserManagement.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        bind();
        startGameButton.setEnabled(true);
        startGameButton.setOnClickListener(v -> {
            Game game = new Game(userManagement.getCurrentUser().getStore());
            if (editTextBetHorse1.getText().toString().isEmpty() &&
                    editTextBetHorse2.getText().toString().isEmpty() &&
                    editTextBetHorse3.getText().toString().isEmpty() &&
                    editTextBetHorse4.getText().toString().isEmpty() &&
                    editTextBetHorse5.getText().toString().isEmpty()) {
                Toast.makeText(GameActivity.this, "Please enter bet", Toast.LENGTH_SHORT).show();
                return;
            }
            game.setBetHourse1(Integer.parseInt(editTextBetHorse1.getText().toString()));
            game.setBetHourse2(Integer.parseInt(editTextBetHorse2.getText().toString()));
            game.setBetHourse3(Integer.parseInt(editTextBetHorse3.getText().toString()));
            game.setBetHourse4(Integer.parseInt(editTextBetHorse4.getText().toString()));
            game.setBetHourse5(Integer.parseInt(editTextBetHorse5.getText().toString()));
            startGame(game);
            startGameButton.setEnabled(false);
        });
        startGameButton.setEnabled(true);
        Intent intent = new Intent(this, ResultActivity.class);
        startActivity(intent);
        finish();
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
        horse5 = findViewById(R.id.seekBarHorse5);
        horse5.setEnabled(false);

        startGameButton = findViewById(R.id.buttonStartGame);
        editTextBetHorse1 = findViewById(R.id.editTextBetHorse1);
        editTextBetHorse2 = findViewById(R.id.editTextBetHorse2);
        editTextBetHorse3 = findViewById(R.id.editTextBetHorse3);
        editTextBetHorse4 = findViewById(R.id.editTextBetHorse4);
        editTextBetHorse5 = findViewById(R.id.editTextBetHorse5);
    }

    private void startGame(Game game) {
        raceHandler.postDelayed(() -> {
            int horse1Progress = horse1.getProgress();
            int horse2Progress = horse2.getProgress();
            int horse3Progress = horse3.getProgress();
            int horse4Progress = horse4.getProgress();
            int horse5Progress = horse5.getProgress();

            horse1BaseSpeed = random.nextInt(5);
            horse2BaseSpeed = random.nextInt(5);
            horse3BaseSpeed = random.nextInt(5);
            horse4BaseSpeed = random.nextInt(5);
            horse5BaseSpeed = random.nextInt(5);

            int change1 = horse1BaseSpeed + random.nextInt(20);
            int change2 = horse2BaseSpeed + random.nextInt(20);
            int change3 = horse3BaseSpeed + random.nextInt(20);
            int change4 = horse4BaseSpeed + random.nextInt(20);
            int change5 = horse5BaseSpeed + random.nextInt(20);

            horse1.setProgress(horse1Progress + change1);
            horse2.setProgress(horse2Progress + change2);
            horse3.setProgress(horse3Progress + change3);
            horse4.setProgress(horse4Progress + change4);
            horse5.setProgress(horse5Progress + change5);

            if (horse1Progress == 1000) {
                game.setHourseWinning(1);
            } else if (horse2Progress == 1000) {
                game.setHourseWinning(2);
            } else if (horse3Progress == 1000) {
                game.setHourseWinning(3);
            } else if (horse4Progress == 1000) {
                game.setHourseWinning(4);
            } else if (horse5Progress == 1000) {
                game.setHourseWinning(5);
            }
            if (game.getTotalWinningHourse() != 3) {
                startGame(game);
            }
        }, 100);
    }
}