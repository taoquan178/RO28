package org.example.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseUtil {
    private static DatabaseUtil dbIsntance;
    private static Connection con;

    // kiểm tra DatabaseUtil đã tạo hay chưa. nếu chưa tạo thì nó sẽ khởi tạo 1 lần
    // khởi tạo 1 lần để tránh khởi tạo nhiều lần dẫn tới giảm hiệu năng máy
    public static DatabaseUtil getDbIsntance() {
        if (dbIsntance == null) {
            dbIsntance = new DatabaseUtil();
        }
        return dbIsntance;
    }

    public static void closeConnection(Connection conn) {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getDatabaseConnection() {
        try {
            Properties properties = new Properties();
            // Đọc những thông tin trong properties file
            properties.load(Files.newInputStream(Paths.get("D:\\Workpasce\\WorkpasceSideaIC\\TestingExam1\\src\\main\\resources\\database.properties")));
            String databaseUrl = properties.getProperty("databaseUrl");
            String userName = properties.getProperty("username");
            String password = properties.getProperty("password");
            Class.forName("com.mysql.cj.jdbc.Driver");
            if (con == null) {
                con = DriverManager.getConnection(databaseUrl, userName, password);
                con.setAutoCommit(false);
                System.out.println("Connect to database success");
                return con;
            }
        } catch ( ClassNotFoundException | SQLException | IOException e) {
            e.printStackTrace();
        }
        return con;
    }
}