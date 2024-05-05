package com.example.pithlabhakri;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // Initialize ImageViews
        ImageView product1Image = findViewById(R.id.product1Image);
        ImageView product2Image = findViewById(R.id.product2Image);
        ImageView product3Image = findViewById(R.id.product3Image);
        ImageView product4Image = findViewById(R.id.product4Image);
        ImageView product5Image = findViewById(R.id.product5Image);
        ImageView product6Image = findViewById(R.id.product6Image);
        ImageView product7Image = findViewById(R.id.product7Image);
        ImageView product8Image = findViewById(R.id.product8Image);

        // Initialize Buttons
        Button product1Btn = findViewById(R.id.product1Btn);
        Button product2Btn = findViewById(R.id.product2Btn);
        Button product3Btn = findViewById(R.id.product3Btn);
        Button product4Btn = findViewById(R.id.product4Btn);
        Button product5Btn = findViewById(R.id.product5Btn);
        Button product6Btn = findViewById(R.id.product6Btn);
        Button product7Btn = findViewById(R.id.product7Btn);
        Button product8Btn = findViewById(R.id.product8Btn);

        ImageButton cartButton = findViewById(R.id.cart_button);


        // Set OnClickListener for Product 1 Button
        product1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showProductDetails("Vada Pav", "Added to your cart");
            }
        });

        // Set OnClickListener for Product 2 Button
        product2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showProductDetails("Chicken Biryani", "Added to your cart");
            }
        });

        // Set OnClickListener for Product 3 Button
        product3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showProductDetails("Poha", "Added to your cart");
            }
        });

        // Set OnClickListener for Product 4 Button
        product4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showProductDetails("Veg Kolhapuri Thali", "Added to your cart");
            }
        });

        // Set OnClickListener for Product 5 Button
        product5Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showProductDetails("Mutton Sukkah", "Added to your cart");
            }
        });

        // Set OnClickListener for Product 6 Button
        product6Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showProductDetails("Malvani Fish Thali", "Added to your cart");
            }
        });

        // Set OnClickListener for Product 7 Button
        product7Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showProductDetails("Pithla Bhakri", "Added to your cart");
            }
        });

        // Set OnClickListener for Product 8 Button
        product8Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showProductDetails("Pab Bhaji", "Added to your cart");
            }
        });

        cartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start RegisterActivity
                startActivity(new Intent(MenuActivity.this, CartActivity.class));
            }
        });
    }

    private void showProductDetails(String productName, String description) {
        String productDetails = "Name: " + productName + "\n"
                + "YAYY! " + description + "\n";
        Toast.makeText(this, productDetails, Toast.LENGTH_LONG).show();
    }
}
