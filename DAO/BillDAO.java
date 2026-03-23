package DAO;

import Entity.Bill;
import Util.JdbcUtil;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BillDAO {

    public int create(Bill b) {
        String sql = "INSERT INTO Bills(userId, drinkId, totalAmount, checkInDate, checkOutDate, status) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            return JdbcUtil.executeUpdate(sql,
                    b.getUserId(),
                    b.getDrinkId(),
                    b.getTotalAmount(),
                    b.getCheckInDate(),
                    b.getCheckOutDate(),
                    b.getStatus());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int update(Bill b) {
        String sql = "UPDATE Bills SET userId=?, drinkId=?, totalAmount=?, checkInDate=?, checkOutDate=?, status=? WHERE billId=?";
        try {
            return JdbcUtil.executeUpdate(sql,
                    b.getUserId(),
                    b.getDrinkId(),
                    b.getTotalAmount(),
                    b.getCheckInDate(),
                    b.getCheckOutDate(),
                    b.getStatus(),
                    b.getBillId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int delete(int id) {
        String sql = "DELETE FROM Bills WHERE billId=?";
        try {
            return JdbcUtil.executeUpdate(sql, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<Bill> findAll() {
        List<Bill> list = new ArrayList<>();
        String sql = "SELECT * FROM Bills";

        try {
            ResultSet rs = JdbcUtil.executeQuery(sql);
            while (rs.next()) {
                list.add(new Bill(
                        rs.getInt("billId"),
                        rs.getInt("userId"),
                        rs.getInt("drinkId"),
                        rs.getBigDecimal("totalAmount"),
                        rs.getDate("checkInDate"),
                        rs.getDate("checkOutDate"),
                        rs.getString("status")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Bill findById(int id) {
        String sql = "SELECT * FROM Bills WHERE billId=?";
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