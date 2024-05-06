package com.example.pithlabhakri;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

public class CartActivity extends AppCompatActivity {

    private CartItemDao cartItemDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        // Initialize Room database
        CartDatabase cartDatabase = Room.databaseBuilder(getApplicationContext(),
                CartDatabase.class, "cart-database").build();
        cartItemDao = cartDatabase.cartItemDao();

        // Initialize Buttons
        Button removeitem1 = findViewById(R.id.removeitem1);
        Button removeitem2 = findViewById(R.id.removeitem2);
        Button removeitem3 = findViewById(R.id.removeitem3);

        removeitem2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Example: Inserting a cart item into the database
                CartItem item = new CartItem("Item Name",10.99);
                item.setItemName("Item Name");
                item.setItemPrice(10.99);
//                cartItemDao.insert(item);

                // Start RemoveItemActivity or any other desired action
                startActivity(new Intent(CartActivity.this, RemoveItemActivity.class));

            }
        });
    }
}
