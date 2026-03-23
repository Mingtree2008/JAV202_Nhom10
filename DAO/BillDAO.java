package DAO;

import Entity.Bill;
import Util.JdbcUtil;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BillDAO implements CrudDAO<Bill, Integer> {

    @Override
    public void insert(Bill entity) {
        String sql = "INSERT INTO Bills(userId, drinkId, totalAmount, checkInDate, checkOutDate, status) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            JdbcUtil.executeUpdate(sql,
                    entity.getUserId(),
                    entity.getDrinkId(),
                    entity.getTotalAmount(),
                    entity.getCheckInDate(),
                    entity.getCheckOutDate(),
                    entity.getStatus()
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Bill entity) {
        String sql = "UPDATE Bills SET userId = ?, drinkId = ?, totalAmount = ?, checkInDate = ?, checkOutDate = ?, status = ? WHERE billId = ?";
        try {
            JdbcUtil.executeUpdate(sql,
                    entity.getUserId(),
                    entity.getDrinkId(),
                    entity.getTotalAmount(),
                    entity.getCheckInDate(),
                    entity.getCheckOutDate(),
                    entity.getStatus(),
                    entity.getBillId()
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM Bills WHERE billId = ?";
        try {
            JdbcUtil.executeUpdate(sql, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Bill> findAll() {
        List<Bill> list = new ArrayList<>();
        String sql = "SELECT * FROM Bills";

        try {
            ResultSet rs = JdbcUtil.executeQuery(sql);
            while (rs.next()) {
                Bill bill = new Bill(
                        rs.getInt("billId"),
                        rs.getInt("userId"),
                        rs.getInt("drinkId"),
                        rs.getBigDecimal("totalAmount"),
                        rs.getDate("checkInDate"),
                        rs.getDate("checkOutDate"),
                        rs.getString("status")
                );
                list.add(bill);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Bill findById(Integer id) {
        String sql = "SELECT * FROM Bills WHERE billId = ?";
        try {
            ResultSet rs = JdbcUtil.executeQuery(sql, id);
            if (rs.next()) {
                return new Bill(
                        rs.getInt("billId"),
                        rs.getInt("userId"),
                        rs.getInt("drinkId"),
                        rs.getBigDecimal("totalAmount"),
                        rs.getDate("checkInDate"),
                        rs.getDate("checkOutDate"),
                        rs.getString("status")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}