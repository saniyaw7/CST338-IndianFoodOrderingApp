package com.example.pithlabhakri;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;

@Dao
public interface CartDao {
    @Insert
    void insert(CartItem cartItem);

    @Delete
    void delete(CartItem cartItem);

 
}
