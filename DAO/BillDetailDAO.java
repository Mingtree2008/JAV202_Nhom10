package DAO;

import Entity.BillDetail;
import Util.JdbcUtil;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BillDetailDAO implements CrudDAO<BillDetail, Integer> {

    @Override
    public void insert(BillDetail entity) {
        String sql = "INSERT INTO BillDetails(billId, drinkId, quantity, unitPrice, price) VALUES (?, ?, ?, ?, ?)";
        try {
            JdbcUtil.executeUpdate(sql,
                    entity.getBillId(),
                    entity.getDrinkId(),
                    entity.getQuantity(),
                    entity.getUnitPrice(),
                    entity.getPrice()
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(BillDetail entity) {
        String sql = "UPDATE BillDetails SET billId = ?, drinkId = ?, quantity = ?, unitPrice = ?, price = ? WHERE billDetailId = ?";
        try {
            JdbcUtil.executeUpdate(sql,
                    entity.getBillId(),
                    entity.getDrinkId(),
                    entity.getQuantity(),
                    entity.getUnitPrice(),
                    entity.getPrice(),
                    entity.getBillDetailId()
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM BillDetails WHERE billDetailId = ?";
        try {
            JdbcUtil.executeUpdate(sql, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<BillDetail> findAll() {
        List<BillDetail> list = new ArrayList<>();
        String sql = "SELECT * FROM BillDetails";

        try {
            ResultSet rs = JdbcUtil.executeQuery(sql);
            while (rs.next()) {
                BillDetail bd = new BillDetail(
                        rs.getInt("billDetailId"),
                        rs.getInt("billId"),
                        rs.getInt("drinkId"),
                        rs.getInt("quantity"),
                        rs.getBigDecimal("unitPrice"),
                        rs.getBigDecimal("price")
                );
                list.add(bd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public BillDetail findById(Integer id) {
        String sql = "SELECT * FROM BillDetails WHERE billDetailId = ?";
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