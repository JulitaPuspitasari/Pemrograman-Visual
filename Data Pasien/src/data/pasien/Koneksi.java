package data.pasien;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Koneksi {
    private static Connection conn;

    public static Connection getConnection() {
        if (conn == null) {
            try {
                String url = "jdbc:mysql://100.115.114.8:3306/db_pasien?useSSL=false&allowPublicKeyRetrieval=true&connectTimeout=5000&socketTimeout=5000";
                String user = "pasien_app";
                String password = "P@sien2026!";
                conn = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                System.out.println("Koneksi gagal: " + e.getMessage());
            }
        }
        return conn;
    }
}
