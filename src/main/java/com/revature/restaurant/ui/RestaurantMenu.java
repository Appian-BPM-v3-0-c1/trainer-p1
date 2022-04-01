package com.revature.restaurant.ui;

import com.revature.restaurant.daos.CrudDAO;
import com.revature.restaurant.daos.RestaurantDAO;
import com.revature.restaurant.daos.ReviewDAO;
import com.revature.restaurant.models.Restaruant;
import com.revature.restaurant.models.Review;

import java.util.List;
import java.util.Scanner;

public class RestaurantMenu implements IMenu {
    CrudDAO<Restaruant> restaurantDAO = new RestaurantDAO();
    CrudDAO<Review> reviewCrudDAO = new ReviewDAO();

    @Override
    public void start() {
        char input = ' ';
        boolean exit = false;
        Scanner scan = new Scanner(System.in);

        while (!exit) {
            System.out.println("\nWelcome to restaurant menu!");
            System.out.println("[1] View all restaurants");
            System.out.println("[2] Search restaurant");
            System.out.println("[3] Create restaurant");
            System.out.println("[x] Exit");

            System.out.print("\nEnter: ");
            input = scan.next().charAt(0);

            switch (input) {
                case '1':
                    viewAllRestaurants();
                    break;
                case '2':
                    break;
                case '3':
                    createRestaurant();
                    break;
                case 'x':
                    exit = true;
                    break;
                default:
                    System.out.println("\nInvalid input!");
                    break;
            }
        }
    }

    private void createRestaurant() {
        char input = ' ';
        boolean exit = false;
        boolean confirm = false;
        Scanner scan = new Scanner(System.in);
        Restaruant restaurant = new Restaruant();

        while (!exit) {
            System.out.print("\nEnter in restaurant name: ");
            restaurant.setName(scan.next().toLowerCase());

            System.out.print("\nEnter in restaurant city: ");
            restaurant.setCity(scan.next().toLowerCase());

            System.out.print("\nEnter in restaurant state: ");
            restaurant.setState(scan.next().toLowerCase());

            while (!confirm) {
                System.out.println("\nIs this correct? (y/n)\n");
                System.out.println(restaurant);

                input = scan.next().charAt(0);
                switch (input) {
                    case 'y':
                        restaurantDAO.save(restaurant);
                        System.out.println("\nRestaurant created successfully!");
                        exit = true;
                        confirm = true;
                        break;
                    case 'n':
                        confirm = true;
                        break;
                    default:
                        System.out.println("\nInvalid input!");
                        break;
                }
            }
        }
    }

    private void viewAllRestaurants() {
        int input = 0;
        Scanner scan = new Scanner(System.in);
        Review review = new Review();
        List<Restaruant> restList = restaurantDAO.findAll();

        for (int i = 0; i < restList.size(); i++) {
            System.out.println("[" + i + "] " + restList.get(i).getName());
        }

        while (true) {
            System.out.print("\nSelect a restaurant to view reviews: ");
            input = scan.nextInt();
            if (input >= restList.size()) {
                System.out.println("\nInvalid input");
            } else {
                review = reviewCrudDAO.findById(restList.get(input).getId());
                System.out.println(restList.get(input));
                System.out.println(review);

                break;
            }
        }
    }
}
