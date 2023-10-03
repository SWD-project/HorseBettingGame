package com.example.horsebetting;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {
    private ImageView horse1ImageView;
    private TextView balanceTextView;
    private TextView playerWinningsTextView;
    Handler raceHandler = new Handler();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        horse1ImageView = findViewById(R.id.horse1ImageView);
        balanceTextView = findViewById(R.id.balanceTextView);
        playerWinningsTextView = findViewById(R.id.playerWinningsTextView);

        // Nhận dữ liệu từ GameActivity
        Intent intent = getIntent();
        int horse1ImageResource = intent.getIntExtra("horse1Image", R.drawable.horse1);
        int currentBalance = intent.getIntExtra("currentBalance", 0);
        int winnings = intent.getIntExtra("winnings", 0);
        boolean isWinner = winnings > 0;

        horse1ImageView.setImageResource(horse1ImageResource);

        balanceTextView.setText("Tổng số tiền: $" + currentBalance);
        playerWinningsTextView.setText("Số tiền thắng cược: $" + winnings);

        if (isWinner) {
            balanceTextView.setTextColor(getResources().getColor(R.color.green));
        } else {
            balanceTextView.setTextColor(getResources().getColor(R.color.red));
        }
        raceHandler.postDelayed(() -> {
            Intent newIntent = new Intent(this, GameActivity.class);
            startActivity(newIntent);
            finish();
        }, 5000);
    }
}
