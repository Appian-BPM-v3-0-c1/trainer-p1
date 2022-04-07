package com.revature.restaurant.models;

/* models to store Review data's */
public class Review {
    private int id;
    private String rating;
    private String message;
    private String username;
    private int restaurantId;
    private int userId;

    public Review() {
    }

    public Review(int id, String rating, String message, String username, int restaurantId, int userId) {
        this.id = id;
        this.rating = rating;
        this.message = message;
        this.username = username;
        this.restaurantId = restaurantId;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "\nRating : " + rating + "\nReview: "  + message + "\nUsername: " + username;
    }
}
