package com.revature.restaurant.ui;

import com.revature.restaurant.models.Restaruant;
import com.revature.restaurant.models.Review;
import com.revature.restaurant.models.User;
import com.revature.restaurant.services.ReviewService;

import java.util.List;
import java.util.Scanner;

public class ReviewMenu implements IMenu {
    private final User user;
    private final ReviewService reviewService;

    public ReviewMenu(User user, ReviewService reviewService) {
        this.user = user;
        this.reviewService = reviewService;
    }

    Review review = new Review();
    Scanner scan = new Scanner(System.in);

    @Override
    public void start() {
        char input = ' ';

        exit: {
            while (true) {
                System.out.println("\nWelcome to review menu " +user.getUsername() + "!");
                System.out.println("[1] Leave a review");
                System.out.println("[x] Exit");

                input = scan.next().charAt(0);
                scan.nextLine();

                switch (input) {
                    case '1':
                        createReview();
                        break;
                    case 'x':
                        break exit;
                    default:
                        System.out.println("\nInvalid input!");
                        break;
                }
            }
        }
    }

    private void createReview() {
        int input = 0;

        List<Restaruant> restaruants = reviewService.getRestaurantDAO().findAll();

        while (true) {
            System.out.println();
            for (int i = 0; i < restaruants.size(); i++) {
                System.out.println("[" + (i + 1) + "] " + restaruants.get(i).getName());
            }

            System.out.print("\nPick a restaurant to review: ");
            input = scan.nextInt() - 1;
            scan.nextLine();

            if (input < restaruants.size()) {
                System.out.println("\nCreating review for " + restaruants.get(input).getName() + "!");

                while (true) {

                    System.out.print("\nEnter in rating: ");
                    String rating = scan.nextLine();

                    if (reviewService.isValidRating(rating)) {
                        review.setRating(rating);
                        break;
                    } else {
                        System.out.println("\nInvalid rating!");
                    }
                }

                System.out.print("\nEnter in review: ");
                String msg = scan.nextLine();
                review.setMessage(msg);
                review.setUsername(user.getUsername());
                review.setRestaurantId(restaruants.get(input).getId());
                review.setUserId(user.getId());

                System.out.println("\nPlease confirm your review (y/n)");
                System.out.println(review);

                System.out.print("\nEnter: ");
                if (scan.next().charAt(0) == 'y') {
                    reviewService.getReviewDAO().save(review);
                    System.out.println("\nReview created successfully!");
                    break;
                }
            } else {
                System.out.println("\nInvalid input!");
            }
        }
    }
}
