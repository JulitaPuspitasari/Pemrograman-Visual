package rekam.medis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Koneksi {
    private static Connection conn;

    public static Connection getConnection() {
        if (conn == null) {
            try {
                String url = "jdbc:mysql://100.115.114.8:3306/db_rekam_medis?useSSL=false&allowPublicKeyRetrieval=true&connectTimeout=5000&socketTimeout=5000";
                String user = "rekam_app";
                String password = "R3kam@Medis2026!";
                conn = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                System.out.println("Koneksi gagal: " + e.getMessage());
            }
        }
        return conn;
    }
}
