package com.revature.restaurant.services;

import com.revature.restaurant.daos.RestaurantDAO;
import com.revature.restaurant.daos.ReviewDAO;

public class ReviewService {
    private final ReviewDAO reviewDAO;
    private final RestaurantDAO restaurantDAO;

    public ReviewService(ReviewDAO reviewDAO, RestaurantDAO restaurantDAO) {
        this.reviewDAO = reviewDAO;
        this.restaurantDAO = restaurantDAO;
    }

    public ReviewDAO getReviewDAO() {
        return reviewDAO;
    }

    public RestaurantDAO getRestaurantDAO() {
        return restaurantDAO;
    }

    public boolean isValidRating(String rating) {
        return rating.matches("^[0-5]");
    }
}
