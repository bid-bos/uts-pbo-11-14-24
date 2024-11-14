package utspbo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class database_conection_uts {
    private static final String URL = "jdbc:mysql://localhost:3306/utspbo"; 
    private static final String USERNAME = "root"; // Ganti dengan username MySQL kamu
    private static final String PASSWORD = ""; // Ganti dengan password MySQL kamu

    public static Connection getConnection() throws SQLException {
        try {
            // Cek koneksi ke database
            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            return conn;  // Mengembalikan objek koneksi jika berhasil
        } catch (SQLException e) {
            System.out.println("Koneksi gagal: " + e.getMessage());
            throw e;  // Melempar kembali pengecualian jika gagal
        }
    }
}
