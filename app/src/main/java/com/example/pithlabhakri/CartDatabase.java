package com.example.pithlabhakri;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {CartItem.class}, version = 1, exportSchema = false)
public abstract class CartDatabase extends RoomDatabase {
    public abstract CartDao cartDao();

    public CartItemDao cartItemDao() {
        return null;
    }
}
