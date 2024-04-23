package com.example.pithlabhakri;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button registerButton;
    private CheckBox showPasswordCheckBox; // CheckBox for "Show Password"
    private AppDatabase db;
    private ImageButton backButton; // Back button on the navigation bar

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Initialize UI components
        backButton = findViewById(R.id.backButton); // Initialize back button
        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        registerButton = findViewById(R.id.registerButton);
        showPasswordCheckBox = findViewById(R.id.showPasswordCheckBox); // Initialize CheckBox

        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "database-name").build();

        // Set click listener for the register button
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Retrieve username and password entered by the user
                final String username = usernameEditText.getText().toString().trim();
                final String password = passwordEditText.getText().toString().trim();

                // Validate password
                if (!isValidPassword(password)) {
                    Toast.makeText(RegisterActivity.this, "Invalid password. Please follow the password criteria.", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Perform registration logic (e.g., validation, saving to database)
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            User user = new User();
                            user.username = username;
                            user.password = password;
                            db.userDao().insert(user);

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(RegisterActivity.this, "User registered successfully", Toast.LENGTH_SHORT).show();
                                }
                            });
                        } catch (Exception e) {
                            e.printStackTrace();
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(RegisterActivity.this, "Error registering user", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    }
                }).start();
            }
        });

        // Set OnCheckedChangeListener for the showPasswordCheckBox
        showPasswordCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // Toggle password visibility
                if (isChecked) {
                    // Show password
                    passwordEditText.setInputType(InputType.TYPE_CLASS_TEXT);
                } else {
                    // Mask password
                    passwordEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
            }
        });

        // Set click listener for the back button
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        db.close();
    }

    private boolean isValidPassword(String password) {
        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";
        return password.matches(regex);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        // Add any additional logic you want to execute when the back button is pressed
    }
}
