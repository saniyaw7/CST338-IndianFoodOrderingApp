package com.example.pithlabhakri;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        // Initialize Buttons
        Button removeitem1 = findViewById(R.id.removeitem1);
        Button removeitem2 = findViewById(R.id.removeitem2);
        Button removeitem3 = findViewById(R.id.removeitem3);

        removeitem2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CartActivity.this, RemoveItemActivity.class);
                startActivity(intent);
            }
        });

    }
}
