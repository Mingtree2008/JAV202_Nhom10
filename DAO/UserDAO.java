package DAO;

import Entity.User;
import Util.JdbcUtil;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    public int create(User u) {
        String sql = "INSERT INTO Users(userName, password, status, email, role) VALUES (?, ?, ?, ?, ?)";
        try {
            return JdbcUtil.executeUpdate(sql,
                    u.getUserName(),
                    u.getPassword(),
                    u.isStatus(),
                    u.getEmail(),
                    u.getRole());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int update(User u) {
        String sql = "UPDATE Users SET userName=?, password=?, status=?, email=?, role=? WHERE userId=?";
        try {
            return JdbcUtil.executeUpdate(sql,
                    u.getUserName(),
                    u.getPassword(),
                    u.isStatus(),
                    u.getEmail(),
                    u.getRole(),
                    u.getUserId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int delete(int id) {
        String sql = "DELETE FROM Users WHERE userId=?";
        try {
            return JdbcUtil.executeUpdate(sql, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        String sql = "SELECT * FROM Users";

        try {
            ResultSet rs = JdbcUtil.executeQuery(sql);
            while (rs.next()) {
                list.add(new User(
                        rs.getInt("userId"),
                        rs.getString("userName"),
                        rs.getString("password"),
                        rs.getBoolean("status"),
                        rs.getString("email"),
                        rs.getString("role")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public User findById(int id) {
        String sql = "SELECT * FROM Users WHERE userId=?";
        try {
            ResultSet rs = JdbcUtil.executeQuery(sql, id);
            if (rs.next()) {
                return new User(
                        rs.getInt("userId"),
                        rs.getString("userName"),
                        rs.getString("password"),
                        rs.getBoolean("status"),
                        rs.getString("email"),
                        rs.getString("role")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}