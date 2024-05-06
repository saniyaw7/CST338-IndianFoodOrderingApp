package com.example.pithlabhakri;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AdminActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);  // Updated to use admin_home layout

        // Retrieve isAdmin flag from intent
        boolean isAdmin = getIntent().getBooleanExtra("isAdmin", false);

        if (isAdmin) {
            // Initialize UI components
            Button changeMenuBtn = findViewById(R.id.changeMenuBtn);
            Button browseDatabaseBtn = findViewById(R.id.browseDatabaseBtn);

            changeMenuBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(AdminActivity.this, ChangeMenu.class);
                    startActivity(intent);
                    Toast.makeText(AdminActivity.this, "You were directed to Change Menu", Toast.LENGTH_SHORT).show();
                }
            });

            browseDatabaseBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(AdminActivity.this, BrowseDatabaseActivity.class);
                    startActivity(intent);
                }
            });


        }
    }
}
