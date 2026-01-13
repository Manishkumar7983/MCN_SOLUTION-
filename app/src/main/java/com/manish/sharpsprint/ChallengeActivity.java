package com.manish.sharpsprint;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import android.database.Cursor;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ChallengeActivity extends AppCompatActivity {

    int wallet = 0;
    int streak = 0;
    String lastCompletedDate = ""; // should come from SharedPreferences later

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge);

        TextView challengeTitle = findViewById(R.id.challengeTitle);
        TextView reward = findViewById(R.id.reward);
        Button completeBtn = findViewById(R.id.completeBtn);

        challengeTitle.setText("Learn 5 Tech Terms");
        reward.setText("Reward: 20 Sharp Coins");

        completeBtn.setOnClickListener(v -> {

            DBHelper dbHelper = new DBHelper(ChallengeActivity.this);
            Cursor cursor = dbHelper.getUser();
            cursor.moveToFirst();

            int wallet = cursor.getInt(1);
            int streak = cursor.getInt(2);
            String lastDate = cursor.getString(3);

            if (isStreakBroken(lastDate)) {
                streak = 0; // 🔥 FOMO penalty
            }

            wallet += 20;
            streak += 1;

            String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            dbHelper.updateUser(wallet, streak, today);

            Intent intent = new Intent(ChallengeActivity.this, WalletActivity.class);
            startActivity(intent);
        });

    }

    // ---------------- STREAK LOGIC ----------------

    private boolean isStreakBroken(String lastDate) {
        if (lastDate == null || lastDate.isEmpty()) return false;

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date last = sdf.parse(lastDate);
            Date today = sdf.parse(sdf.format(new Date()));

            long diff = today.getTime() - last.getTime();
            long days = TimeUnit.MILLISECONDS.toDays(diff);

            return days > 1; // missed a day = streak broken
        } catch (Exception e) {
            return false;
        }
    }

    private String getTodayDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(new Date());
    }
}
