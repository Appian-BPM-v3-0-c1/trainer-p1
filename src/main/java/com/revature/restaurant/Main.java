package com.revature.restaurant;

import com.revature.restaurant.daos.UserDAO;
import com.revature.restaurant.services.UserService;
import com.revature.restaurant.ui.LoginMenu;

public class Main {
    public static void main(String[] args) {
        /* start application */
        new LoginMenu(new UserService(new UserDAO())).start();
    }
}
