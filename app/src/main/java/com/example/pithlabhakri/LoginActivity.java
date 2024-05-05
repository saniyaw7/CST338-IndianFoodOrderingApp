package com.example.pithlabhakri;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.concurrent.Executors;

public class LoginActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private Button loginBtn;
    private CheckBox showPasswordCheckBox; // CheckBox for "Show Password"

    private ImageButton backButton; // Back button on the navigation bar


    private AppDatabase db;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.usernameEditText);
        password = findViewById(R.id.passwordEditText);
        loginBtn = findViewById(R.id.loginBtn);
        backButton = findViewById(R.id.backButton); // Initialize back button
        showPasswordCheckBox = findViewById(R.id.showPasswordCheckBox); // Initialize CheckBox


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

        // Set click listener for the back button
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        showPasswordCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // Toggle password visibility
                if (isChecked) {
                    // Show password
                    password.setInputType(InputType.TYPE_CLASS_TEXT);
                } else {
                    // Mask password
                    password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
            }
        });
    }

    public void validateCredentials(String username, String password) {
        Executors.newSingleThreadExecutor().execute(() -> {
            try {
                if (db != null && db.userDao() != null) {
                    User user = db.userDao().findUserByUsernameAndPassword(username, password);

                    // Check for admin accounts
                    if (("admin1".equals(username) && "admin123".equals(password)) ||
                            ("admin2".equals(username) && "admin456".equals(password))) {
                        runOnUiThread(() -> {
                            navigateToAdminActivity(true);  // Navigate to AdminActivity with isAdmin=true
                        });
                    }
                    // Check for regular user
                    else if (user != null) {
                        runOnUiThread(() -> {
                            navigateToMenuActivity(user);  // Navigate to MenuActivity with user details
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

    private void navigateToAdminActivity(boolean isAdmin) {
        Intent intent = new Intent(LoginActivity.this, AdminActivity.class);
        intent.putExtra("isAdmin", isAdmin);  // Pass isAdmin flag to AdminActivity
        startActivity(intent);
        finish();
    }

    private void navigateToMenuActivity(User user) {
        Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
        intent.putExtra("userId", user.getId());  // Pass userId to MenuActivity
        startActivity(intent);
        finish();
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
