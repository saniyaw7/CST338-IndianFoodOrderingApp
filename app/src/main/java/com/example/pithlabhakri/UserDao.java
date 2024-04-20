package com.example.pithlabhakri;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    void insert(User user);

    @Query("SELECT * FROM User WHERE username = :username AND password = :password")
    User login(String username, String password);

    @Query("SELECT * FROM User WHERE username = :username AND password = :password")
    User findUserByUsernameAndPassword(String username, String password); // To retrieve isAdmin

    @Query("SELECT * FROM User WHERE username = :username AND password = :password AND isAdmin = 1")
    User findAdminByUsernameAndPassword(String username, String password);

    @Query("SELECT * FROM User")
    List<User> getAllUsers();
}
