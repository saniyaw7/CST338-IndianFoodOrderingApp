package com.example.pithlabhakri;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        Button changeMenuBtn = findViewById(R.id.changeMenuBtn);
        Button browseDatabaseBtn = findViewById(R.id.browseDatabaseBtn);

        changeMenuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle "Change Menu" button click
                // Add your logic to navigate or perform actions related to changing the menu
                // Example:
                // Intent intent = new Intent(AdminActivity.this, ChangeMenuActivity.class);
                // startActivity(intent);
            }
        });

        browseDatabaseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle "Browse Database" button click
                // Add your logic to navigate or perform actions related to browsing the database
                // Example:
                // Intent intent = new Intent(AdminActivity.this, BrowseDatabaseActivity.class);
                // startActivity(intent);
            }
        });
    }
}
