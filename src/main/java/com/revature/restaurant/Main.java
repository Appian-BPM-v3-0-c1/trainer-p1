package com.revature.restaurant;

import com.revature.restaurant.connection.DatabaseConnection;
import com.revature.restaurant.ui.MainMenu;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        /* start application */
        new MainMenu().start();
    }
}
