package com.revature.restaurant.daos;

import com.revature.restaurant.connection.DatabaseConnection;
import com.revature.restaurant.models.Restaruant;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RestaurantDAO implements CrudDAO<Restaruant> {
    Connection con = DatabaseConnection.getCon();

    @Override
    public int save(Restaruant obj) {
        int n = 0;

        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO restaurants (name, city, state) VALUES (?, ?, ?)");
            ps.setString(1, obj.getName());
            ps.setString(2, obj.getCity());
            ps.setString(3, obj.getState());

            n = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return n;
    }

    @Override
    public List<Restaruant> findAll() {
        List<Restaruant> restList = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM restaurants");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Restaruant restaruant = new Restaruant();

                restaruant.setId(rs.getInt("id"));
                restaruant.setName(rs.getString("name"));
                restaruant.setCity(rs.getString("city"));
                restaruant.setState(rs.getString("state"));

                restList.add(restaruant);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return restList;
    }

    @Override
    public Restaruant findById(int id) {
        return null;
    }

    @Override
    public List<Restaruant> findAllById(int id) {
        return null;
    }

    @Override
    public boolean update(Restaruant updatedObj) {
        return false;
    }

    @Override
    public boolean removeById(String id) {
        return false;
    }

    public List<Restaruant> findByName(String name) {
        List<Restaruant> restaruants = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM restaurants WHERE name LIKE ?");
            ps.setString(1, "%" + name + "%");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Restaruant restaruant = new Restaruant();

                restaruant.setId(rs.getInt("id"));
                restaruant.setName(rs.getString("name"));
                restaruant.setCity(rs.getString("city"));
                restaruant.setState(rs.getString("state"));

                restaruants.add(restaruant);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return restaruants;
    }
}
