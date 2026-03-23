package Util;

import java.sql.*;

public class JdbcUtil {

    static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    static String dburl = "jdbc:sqlserver://localhost:1433;databaseName=PolyCoffee;encrypt=true;trustServerCertificate=true";
    static String username = "sa";
    static String password = "cac";

    
    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Không load được Driver SQL Server", e);
        }
    }


    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dburl, username, password);
    }


    public static PreparedStatement createPreStmt(String sql, Object... values) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement stmt;

        if (sql.trim().startsWith("{")) {
            stmt = connection.prepareCall(sql);
        } else {
            stmt = connection.prepareStatement(sql);
        }

        for (int i = 0; i < values.length; i++) {
            stmt.setObject(i + 1, values[i]);
        }

        return stmt;
    }


    public static int executeUpdate(String sql, Object... values) {
        try (Connection con = getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            for (int i = 0; i < values.length; i++) {
                stmt.setObject(i + 1, values[i]);
            }

            return stmt.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException("Lỗi executeUpdate", e);
        }
    }


    public static ResultSet executeQuery(String sql, Object... values) {
        try {
            Connection con = getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);

            for (int i = 0; i < values.length; i++) {
                stmt.setObject(i + 1, values[i]);
            }

            return stmt.executeQuery();

        } catch (Exception e) {
            throw new RuntimeException("Lỗi executeQuery", e);
        }
    }
}