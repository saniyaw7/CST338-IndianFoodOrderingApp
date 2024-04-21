package com.example.pithlabhakri;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button loginBtn = findViewById(R.id.loginBtn);
        Button createAccountBtn = findViewById(R.id.createAccountBtn);

        // Set click listener for the Login button
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start LoginActivity
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        });

        // Set click listener for the Create Account button
        createAccountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start RegisterActivity
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
            }
        });
    }
}
