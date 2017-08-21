package com.imooc.utils;

import java.sql.*;

/**
 *
 */
public class MySQLUtils {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final String DRIVEVRCLASS = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/imooc_project";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(DRIVEVRCLASS);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }

    /**
     * 释放资源
     * @param connection
     * @param pstmt
     * @param rs
     */
    public static void release(Connection connection, PreparedStatement pstmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(getConnection());
    }

}
