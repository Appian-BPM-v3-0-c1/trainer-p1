package com.revature.restaurant.services;

import com.revature.restaurant.daos.RestaurantDAO;
import com.revature.restaurant.daos.ReviewDAO;

/*Check and validates input*/
public class RestaurantService {
    private final RestaurantDAO restaurantDAO;
    private final ReviewDAO reviewDAO;

    public RestaurantService(RestaurantDAO restaurantDAO, ReviewDAO reviewDAO) {
        this.restaurantDAO = restaurantDAO;
        this.reviewDAO = reviewDAO;
    }

    public RestaurantDAO getRestaurantDAO() {
        return restaurantDAO;
    }

    public ReviewDAO getReviewDAO() {
        return reviewDAO;
    }


}
