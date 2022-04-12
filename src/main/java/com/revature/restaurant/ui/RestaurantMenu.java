package com.revature.restaurant.ui;

import com.revature.restaurant.models.Restaruant;
import com.revature.restaurant.models.Review;
import com.revature.restaurant.models.User;
import com.revature.restaurant.services.RestaurantService;

import java.util.List;
import java.util.Scanner;

public class RestaurantMenu implements IMenu {
    private final RestaurantService restaurantService;
    private final User user;

    public RestaurantMenu(RestaurantService restaurantService, User user) {
        this.restaurantService = restaurantService;
        this.user = user;
    }

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
                    searchRestaurant();
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

        Scanner scan = new Scanner(System.in);
        Restaruant restaurant = new Restaruant();

        /* loop to ask user to enter in restaurant */
        while (!exit) {
            boolean confirm = false;

            /* get restaurant name */
            System.out.print("\nEnter in restaurant name: ");
            restaurant.setName(scan.next().toLowerCase());

            /* get restaurant city */
            System.out.print("\nEnter in restaurant city: ");
            restaurant.setCity(scan.next().toLowerCase());

            /* get restaurant state */
            System.out.print("\nEnter in restaurant state: ");
            restaurant.setState(scan.next().toLowerCase());

            /* loop to confirm */
            while (!confirm) {
                System.out.println("\nIs this correct? (y/n)");
                System.out.println(restaurant);

                System.out.print("\nEnter: ");
                input = scan.next().charAt(0);

                switch (input) {
                    case 'y':
                        restaurantService.getRestaurantDAO().save(restaurant);
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

    private void searchRestaurant() {
        String name = "";
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.print("\nSearch restaurant: ");
            name = scan.nextLine().toLowerCase();

            List<Restaruant> restaruants = restaurantService.getRestaurantDAO().findByName(name);

            if (restaruants.isEmpty()) {
                System.out.println("\nInvalid search!");
            } else {
                for (Restaruant res : restaruants) {
                    System.out.println(res);
                }
            }
        }
    }

    private void viewAllRestaurants() {
        int input = 0;
        Scanner scan = new Scanner(System.in);
        List<Restaruant> restList = restaurantService.getRestaurantDAO().findAll();

        /* loop through restaurant list and print out the restaurants */
        System.out.println();
        for (int i = 0; i < restList.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + restList.get(i).getName());
        }

        /* loop to ask user to enter a restaurant */
        while (true) {
            System.out.print("\nSelect a restaurant to view reviews: ");

            /* get the user restaurant selection */
            input = scan.nextInt() - 1;

            /* if the input is not of any restaurant, printout invalid input */
            if (input > restList.size()) {
                System.out.println("\nInvalid input");
            } else {

                /* store the reviews of that restaurant into a review list */
                List<Review> revList = restaurantService.getReviewDAO().findAllById(restList.get(input).getId());

                /* printout the selected restaurant */
                System.out.println(restList.get(input));

                /* printout all the reviews for that restaurant */
                for (Review rev : revList) {
                    System.out.println(rev);
                }
                break;
            }
        }
    }
}
