package com.example.pithlabhakri;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class RemoveItemActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_removeitem);


        Button removebutton = findViewById(R.id.removebutton);

        removebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RemoveItemActivity.this, CheckoutActivity.class);
                startActivity(intent);
            }
        });

    }
}
