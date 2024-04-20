package com.example.pithlabhakri;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.annotation.NonNull;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pithlabhakri.AppDatabase;
import com.example.pithlabhakri.User;

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

        RoomDatabase.Callback myCallback = new RoomDatabase.Callback() {
            @Override
            public void onCreate(@NonNull SupportSQLiteDatabase db) {
                super.onCreate(db);
            }

            @Override
            public void onOpen(@NonNull SupportSQLiteDatabase db) {
                super.onOpen(db);
            }
        };

        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "database-name").build();
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String enteredUsername = username.getText().toString();
                String enteredPassword = password.getText().toString();
                validateCredentials(enteredUsername, enteredPassword);

            }
        });

    }
    private boolean validateAdmin(String username, String password) {

        return username.equals("admin") && password.equals("admin123");
    }

    public void validateCredentials(String username, String password) {
        Executors.newSingleThreadExecutor().execute(() -> {
            User user = db.userDao().findUserByUsernameAndPassword(username, password);
            boolean credentialsMatch = user != null;

            runOnUiThread(() -> {
                if (credentialsMatch) {
                    navigateToLandingPage(true);
                } else {
                    Toast.makeText(LoginActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                }
            });
        });
    }


    private void navigateToLandingPage(boolean isAdmin) {
        Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
        startActivity(intent);
        finish();
    }

}