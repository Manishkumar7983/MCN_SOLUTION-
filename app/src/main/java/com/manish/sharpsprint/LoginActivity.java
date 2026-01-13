package com.manish.sharpsprint;

//package com.example.sharpsprint;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText username;
    Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username);
        loginBtn = findViewById(R.id.loginBtn);

        loginBtn.setOnClickListener(v -> {
            String name = username.getText().toString();

            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);

            intent.putExtra("username", name);
            startActivity(intent);
        });
        DBHelper dbHelper = new DBHelper(this);

        Cursor cursor = dbHelper.getUser();

        if (!cursor.moveToFirst()) {
            dbHelper.insertUser();
        }

    }
}
