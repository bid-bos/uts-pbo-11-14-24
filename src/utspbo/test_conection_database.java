package utspbo;

import java.sql.Connection;
import java.sql.SQLException;

public class test_conection_database {
    public static void main(String[] args) {
        try {
            // Mencoba untuk mendapatkan koneksi
            Connection conn = database_conection_uts.getConnection();
            if (conn != null) {
                System.out.println("Koneksi berhasil!");
                conn.close();  // Jangan lupa untuk menutup koneksi setelah selesai
            }
        } catch (SQLException e) {
            System.out.println("Koneksi gagal: " + e.getMessage());
        }
    }
}
