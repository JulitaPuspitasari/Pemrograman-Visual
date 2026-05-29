package gym.koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class KoneksiDatabase {

    private static final String URL = "jdbc:mariadb://100.115.114.8:3306/db_gym";
    private static final String USER = "db_gym_user";
    private static final String PASSWORD = "@db_gym_user007";

    public static Connection getKoneksi() {
        Connection conn = null;
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Driver MariaDB tidak ditemukan!\n" + e.getMessage());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Koneksi database gagal!\n" + e.getMessage());
        }
        return conn;
    }
}
