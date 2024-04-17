package com.example.pithlabhakri;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

        // Set OnClickListener for Product 1 Button
        product1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showProductDetails("Product 1", "Description 1", "$9.99");
            }
        });

        // Set OnClickListener for Product 2 Button
        product2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showProductDetails("Product 2", "Description 2", "$20.00");
            }
        });

        // Set OnClickListener for Product 3 Button
        product3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showProductDetails("Product 3", "Description 3", "$30.00");
            }
        });

        // Set OnClickListener for Product 4 Button
        product4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showProductDetails("Product 4", "Description 4", "$40.00");
            }
        });

        // Set OnClickListener for Product 5 Button
        product5Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showProductDetails("Product 5", "Description 5", "$50.00");
            }
        });

        // Set OnClickListener for Product 6 Button
        product6Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showProductDetails("Product 6", "Description 6", "$60.00");
            }
        });

        // Set OnClickListener for Product 7 Button
        product7Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showProductDetails("Product 7", "Description 7", "$70.00");
            }
        });

        // Set OnClickListener for Product 8 Button
        product8Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showProductDetails("Product 8", "Description 8", "$80.00");
            }
        });
    }

    private void showProductDetails(String productName, String description, String price) {
        String productDetails = "Name: " + productName + "\n"
                + "Description: " + description + "\n"
                + "Price: " + price;

        Toast.makeText(this, productDetails, Toast.LENGTH_LONG).show();
    }
}
