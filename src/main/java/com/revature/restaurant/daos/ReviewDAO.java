package com.revature.restaurant.daos;

import com.revature.restaurant.connection.DatabaseConnection;
import com.revature.restaurant.models.Review;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReviewDAO implements CrudDAO<Review> {
    Connection con = DatabaseConnection.getCon();

    @Override
    public int save(Review obj) {
        int n = 0;

        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO reviews (rating, message, username, restaurant_id, user_id) VALUES (?, ?, ?, ?, ?)");
            ps.setString(1, obj.getRating());
            ps.setString(2, obj.getMessage());
            ps.setString(3, obj.getUsername());
            ps.setInt(4, obj.getRestaurantId());
            ps.setInt(5, obj.getUserId());

            n = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return n;
    }

    @Override
    public List<Review> findAll() {
        return null;
    }

    @Override
    public Review findById(int id) {
        return null;
    }

    @Override
    public List<Review> findAllById(int id) {
        List<Review> revList = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM reviews WHERE restaurant_id = ?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Review review = new Review();

                review.setId(rs.getInt("id"));
                review.setRating(rs.getString("rating"));
                review.setMessage(rs.getString("message"));
                review.setUsername(rs.getString("username"));
                review.setRestaurantId(rs.getInt("restaurant_id"));
                review.setUserId(rs.getInt("user_id"));

                revList.add(review);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return revList;
    }

    @Override
    public boolean update(Review updatedObj) {
        return false;
    }

    @Override
    public boolean removeById(String id) {
        return false;
    }
}
