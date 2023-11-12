package rikkei.academy.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    // khai bao thuoc tinh Driver ket noi va mySQL
    private static final String  DRIVER_JBDC  = "com.mysql.cj.jdbc.Driver" ;
    // khai bao thuoc tinh URL ket noi
    private static final String URL = "jdbc:mysql://localhost:3306/demo_mvc";
    // khai bao thuoc tinh UESR
    private static final String USER = "root" ;
    // khai bao thuoc tinh pasword
    private static final String PASSWORD = "hoangutck57";
    // phuong thuc connection ( lay ve ket noi )
    // chon file build.gradle import thu vien mysql connector java maven 8.0.28
    public static Connection openConnection()  {
        Connection connection = null;
        try {
            // khai bao class cho driver
            Class.forName(DRIVER_JBDC);
            // thuc hien mo ket noi
            connection = DriverManager.getConnection(URL, USER,PASSWORD);
        } catch (ClassNotFoundException e) {
           throw new RuntimeException();
        } catch (SQLException e ) {
            throw new RuntimeException();
        }

        return connection ;
    } ;

    // phuong thuc dong ket noi
    public static void closeConnection(Connection connection) throws SQLException {
        if (connection != null) {
            connection.close();
        }
    };

    // kiểm tra kết nối thành công chưa
    public static void main(String[] args)  {
        System.out.println(ConnectionDB.openConnection());
    }
}
