package DAO;

import Entity.BillDetail;
import Util.JdbcUtil;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BillDetailDAO {

    public int create(BillDetail bd) {
        String sql = "INSERT INTO BillDetails(billId, drinkId, quantity, unitPrice, price) VALUES (?, ?, ?, ?, ?)";
        try {
            return JdbcUtil.executeUpdate(sql,
                    bd.getBillId(),
                    bd.getDrinkId(),
                    bd.getQuantity(),
                    bd.getUnitPrice(),
                    bd.getPrice());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int update(BillDetail bd) {
        String sql = "UPDATE BillDetails SET billId=?, drinkId=?, quantity=?, unitPrice=?, price=? WHERE billDetailId=?";
        try {
            return JdbcUtil.executeUpdate(sql,
                    bd.getBillId(),
                    bd.getDrinkId(),
                    bd.getQuantity(),
                    bd.getUnitPrice(),
                    bd.getPrice(),
                    bd.getBillDetailId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int delete(int id) {
        String sql = "DELETE FROM BillDetails WHERE billDetailId=?";
        try {
            return JdbcUtil.executeUpdate(sql, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<BillDetail> findAll() {
        List<BillDetail> list = new ArrayList<>();
        String sql = "SELECT * FROM BillDetails";

        try {
            ResultSet rs = JdbcUtil.executeQuery(sql);
            while (rs.next()) {
                list.add(new BillDetail(
                        rs.getInt("billDetailId"),
                        rs.getInt("billId"),
                        rs.getInt("drinkId"),
                        rs.getInt("quantity"),
                        rs.getBigDecimal("unitPrice"),
                        rs.getBigDecimal("price")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public BillDetail findById(int id) {
        String sql = "SELECT * FROM BillDetails WHERE billDetailId=?";
        try {
            ResultSet rs = JdbcUtil.executeQuery(sql, id);
            if (rs.next()) {
                return new BillDetail(
                        rs.getInt("billDetailId"),
                        rs.getInt("billId"),
                        rs.getInt("drinkId"),
                        rs.getInt("quantity"),
                        rs.getBigDecimal("unitPrice"),
                        rs.getBigDecimal("price")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}