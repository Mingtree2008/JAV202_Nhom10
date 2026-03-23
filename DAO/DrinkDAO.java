package DAO;

import Entity.Drink;
import Util.JdbcUtil;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DrinkDAO {

    public int create(Drink d) {
        String sql = "INSERT INTO Drinks(typeId, drinkName, cost, image, [describe]) VALUES (?, ?, ?, ?, ?)";
        try {
            return JdbcUtil.executeUpdate(sql,
                    d.getTypeId(),
                    d.getDrinkName(),
                    d.getCost(),
                    d.getImage(),
                    d.getDescribe());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int update(Drink d) {
        String sql = "UPDATE Drinks SET typeId=?, drinkName=?, cost=?, image=?, [describe]=? WHERE drinkId=?";
        try {
            return JdbcUtil.executeUpdate(sql,
                    d.getTypeId(),
                    d.getDrinkName(),
                    d.getCost(),
                    d.getImage(),
                    d.getDescribe(),
                    d.getDrinkId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int delete(int id) {
        String sql = "DELETE FROM Drinks WHERE drinkId=?";
        try {
            return JdbcUtil.executeUpdate(sql, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<Drink> findAll() {
        List<Drink> list = new ArrayList<>();
        String sql = "SELECT * FROM Drinks";

        try {
            ResultSet rs = JdbcUtil.executeQuery(sql);
            while (rs.next()) {
                list.add(new Drink(
                        rs.getInt("drinkId"),
                        rs.getInt("typeId"),
                        rs.getString("drinkName"),
                        rs.getBigDecimal("cost"),
                        rs.getString("image"),
                        rs.getString("describe")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Drink findById(int id) {
        String sql = "SELECT * FROM Drinks WHERE drinkId=?";
        try {
            ResultSet rs = JdbcUtil.executeQuery(sql, id);
            if (rs.next()) {
                return new Drink(
                        rs.getInt("drinkId"),
                        rs.getInt("typeId"),
                        rs.getString("drinkName"),
                        rs.getBigDecimal("cost"),
                        rs.getString("image"),
                        rs.getString("describe")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}