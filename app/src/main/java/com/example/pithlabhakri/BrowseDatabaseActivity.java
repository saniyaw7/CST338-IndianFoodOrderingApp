package com.example.pithlabhakri;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class BrowseDatabaseActivity extends AppCompatActivity {

    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_database);

        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "database-name").build();

        new Thread(new Runnable() {
            @Override
            public void run() {
                // Fetch data from the database
                List<User> users = db.userDao().getAllUsers();

                // Convert the list of users to a string
                StringBuilder usersString = new StringBuilder();
                for (User user : users) {
                    usersString.append("ID: ").append(user.id).append("\n");
                    usersString.append("Username: ").append(user.username).append("\n");
                    usersString.append("Password: ").append(user.password).append("\n\n");
                }

                // Display the data
                TextView textView = findViewById(R.id.userTypeRadioGroup);
                textView.setText(usersString.toString());
            }
        }).start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        db.close();
    }
}
