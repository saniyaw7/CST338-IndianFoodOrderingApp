package com.example.pithlabhakri;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AdminActivity extends AppCompatActivity {

    private TextView adminText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        adminText = findViewById(R.id.adminText);

        adminText.setText("Welcome to Admin Area");
    }
}
