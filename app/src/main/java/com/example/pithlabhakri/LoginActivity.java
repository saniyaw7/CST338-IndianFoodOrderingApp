package com.example.pithlabhakri;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        Button loginBtn = findViewById(R.id.loginBtn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    private void login() {
        String username = usernameEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        if ("testuser1".equals(username) && "testuser1".equals(password)) {
            // Navigate to LandingPage or another activity
            navigateToLandingPage(false); // false because it's not an admin
        } else if ("admin2".equals(username) && "admin2".equals(password)) {
            // Navigate to LandingPage or another activity
            navigateToLandingPage(true); // true because it's an admin
        } else {
            Toast.makeText(this, "Invalid credentials", Toast.LENGTH_SHORT).show();
        }
    }

    private void navigateToLandingPage(boolean isAdmin) {
        // Save user login status using SharedPreferences if needed
        // For demonstration, let's assume "isLoggedIn" is a boolean key and isAdmin is another key
        // SharedPreferences sharedPreferences = getSharedPreferences("user_pref", MODE_PRIVATE);
        // SharedPreferences.Editor editor = sharedPreferences.edit();
        // editor.putBoolean("isLoggedIn", true);
        // editor.putBoolean("isAdmin", isAdmin);
        // editor.apply();

        Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
        startActivity(intent);
        finish();
    }

}
