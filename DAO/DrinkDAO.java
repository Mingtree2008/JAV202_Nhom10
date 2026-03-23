package DAO;

import Entity.Drink;
import Util.JdbcUtil;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DrinkDAO implements CrudDAO<Drink, Integer> {

    // Thêm đồ uống
    @Override
    public void insert(Drink entity) {
        String sql = "INSERT INTO Drinks(typeId, drinkName, cost, image, [describe]) VALUES (?, ?, ?, ?, ?)";
        try {
            JdbcUtil.executeUpdate(sql,
                    entity.getTypeId(),
                    entity.getDrinkName(),
                    entity.getCost(),
                    entity.getImage(),
                    entity.getDescribe()
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    // Cập nhật đồ uống
    @Override
    public void update(Drink entity) {
        String sql = "UPDATE Drinks SET typeId = ?, drinkName = ?, cost = ?, image = ?, [describe] = ? WHERE drinkId = ?";
        try {
            JdbcUtil.executeUpdate(sql,
                    entity.getTypeId(),
                    entity.getDrinkName(),
                    entity.getCost(),
                    entity.getImage(),
                    entity.getDescribe(),
                    entity.getDrinkId()
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    // Xóa đồ uống
    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM Drinks WHERE drinkId = ?";
        try {
            JdbcUtil.executeUpdate(sql, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    // Lấy toàn bộ danh sách
    @Override
    public List<Drink> findAll() {
        List<Drink> list = new ArrayList<>();
        String sql = "SELECT * FROM Drinks";

        try {
            ResultSet rs = JdbcUtil.executeQuery(sql);
            while (rs.next()) {
                Drink drink = new Drink(
                        rs.getInt("drinkId"),
                        rs.getInt("typeId"),
                        rs.getString("drinkName"),
                        rs.getBigDecimal("cost"),
                        rs.getString("image"),
                        rs.getString("describe")
                );
                list.add(drink);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // Lấy 1 đồ uống theo ID
    @Override
    public Drink findById(Integer id) {
        String sql = "SELECT * FROM Drinks WHERE drinkId = ?";
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