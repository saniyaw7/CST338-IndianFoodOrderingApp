package com.example.pithlabhakri;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LoginActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private Button loginBtn;
    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.usernameEditText);
        password = findViewById(R.id.passwordEditText);
        loginBtn = findViewById(R.id.loginBtn);

        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "database-name")
                .addCallback(new RoomDatabase.Callback() {
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                        super.onCreate(db);
                    }

                    @Override
                    public void onOpen(@NonNull SupportSQLiteDatabase db) {
                        super.onOpen(db);
                    }
                })
                .build();

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String enteredUsername = username.getText().toString();
                String enteredPassword = password.getText().toString();
                validateCredentials(enteredUsername, enteredPassword);
            }
        });
    }

    public void validateCredentials(String username, String password) {
        Executors.newSingleThreadExecutor().execute(() -> {
            try {
                if (db != null && db.userDao() != null) {
                    User user = db.userDao().findUserByUsernameAndPassword(username, password);
                    if (user != null) {
                        runOnUiThread(() -> {
                            navigateToLandingPage();
                        });
                    } else {
                        runOnUiThread(() -> {
                            Toast.makeText(LoginActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                        });
                    }
                } else {
                    runOnUiThread(() -> {
                        Toast.makeText(LoginActivity.this, "Database error", Toast.LENGTH_SHORT).show();
                    });
                }
            } catch (Exception e) {
                e.printStackTrace();
                runOnUiThread(() -> {
                    Toast.makeText(LoginActivity.this, "An error occurred: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                });
            }
        });
    }

    private void navigateToLandingPage() {
        Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
        startActivity(intent);
        finish();
    }
}
