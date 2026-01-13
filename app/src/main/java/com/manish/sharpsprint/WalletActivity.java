package com.manish.sharpsprint;

//package com.example.sharpsprint;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class WalletActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet);

        TextView walletView = findViewById(R.id.wallet);
        TextView streakView = findViewById(R.id.streak);

        int wallet = getIntent().getIntExtra("wallet", 0);
        int streak = getIntent().getIntExtra("streak", 0);

        walletView.setText("Sharp Coins: " + wallet);
        streakView.setText("Streak: " + streak + " 🔥");
    }
}
