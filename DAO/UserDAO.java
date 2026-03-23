package DAO;

import Entity.User;
import Util.JdbcUtil;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements CrudDAO<User, Integer> {

    @Override
    public void insert(User entity) {
        String sql = "INSERT INTO Users(userName, password, status, email, role) VALUES (?, ?, ?, ?, ?)";
        try {
            JdbcUtil.executeUpdate(sql,
                    entity.getUserName(),
                    entity.getPassword(),
                    entity.isStatus(),
                    entity.getEmail(),
                    entity.getRole()
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(User entity) {
        String sql = "UPDATE Users SET userName = ?, password = ?, status = ?, email = ?, role = ? WHERE userId = ?";
        try {
            JdbcUtil.executeUpdate(sql,
                    entity.getUserName(),
                    entity.getPassword(),
                    entity.isStatus(),
                    entity.getEmail(),
                    entity.getRole(),
                    entity.getUserId()
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM Users WHERE userId = ?";
        try {
            JdbcUtil.executeUpdate(sql, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        String sql = "SELECT * FROM Users";

        try {
            ResultSet rs = JdbcUtil.executeQuery(sql);
            while (rs.next()) {
                User user = new User(
                        rs.getInt("userId"),
                        rs.getString("userName"),
                        rs.getString("password"),
                        rs.getBoolean("status"),
                        rs.getString("email"),
                        rs.getString("role")
                );
                list.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public User findById(Integer id) {
        String sql = "SELECT * FROM Users WHERE userId = ?";
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