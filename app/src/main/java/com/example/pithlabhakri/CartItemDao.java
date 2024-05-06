package com.example.pithlabhakri;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface CartItemDao {
    @Insert
    void insert(CartItem cartItem);



    @Delete
    void delete(CartItem cartItem);

    @Query("SELECT * FROM CartItem")
    List<CartItem> getAllItems();
}
