package com.revature.restaurant.models;

/* models to store Review data's */
public class Review {
    private int id;
    private int rating;
    private String message;
    private int restaurantId;

    public Review() {
    }

    public Review(int id, int rating, String message, int restaurantId) {
        this.id = id;
        this.rating = rating;
        this.message = message;
        this.restaurantId = restaurantId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    @Override
    public String toString() {
        return "\nRating : " + rating + "\nReview: "  + message;
    }
}
