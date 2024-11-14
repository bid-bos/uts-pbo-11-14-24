/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package utspbo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class CRUD extends javax.swing.JFrame {

    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
    
    public CRUD() {
        initComponents();
        connectDatabase();
    }

  private void connectDatabase() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/utspbo", "root", "");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Database connection failed: " + e.getMessage());
        }
    }
  
      private void createData() {
        String sql = "INSERT INTO tbl_aset (Nama_Aset, Deskripsi_Aset, Jenis_Aset, Status_Aset, lokasi_Aset) VALUES (?, ?, ?, ?, ?)";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, Nama_Aset.getText());
            pstmt.setString(2, Deskripsi_Aset.getText());
            pstmt.setString(3, Jenis_Aset.getText());
            pstmt.setString(4, Status_Aset.getSelectedItem().toString());
            pstmt.setString(5, Lokasi_Aset.getText());
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data created successfully");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Create operation failed: " + e.getMessage());
        }
    }
      
        private void readData() {
        String sql = "SELECT * FROM tbl_aset";
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id_aset") + ", Nama_Aset: " + rs.getString("Nama_Aset"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Read operation failed: " + e.getMessage());
        }
    }
        
        private void updateData() {
        String sql;
        sql = "UPDATE tbl_aset SET Nama_Aset=?, Deskripsi_Aset=?, Jenis_Aset=?, Status_Aset=?, lokasi_Aset=? WHERE id_aset=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, Nama_Aset.getText());
            pstmt.setString(2, Deskripsi_Aset.getText());
            pstmt.setString(3, Jenis_Aset.getText());
            pstmt.setString(4, Status_Aset.getSelectedItem().toString());
            pstmt.setString(5, Lokasi_Aset.getText());
            pstmt.setInt(6, Integer.parseInt(JOptionPane.showInputDialog("Enter ID to update")));
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data updated successfully");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Update operation failed: " + e.getMessage());
        }
    }
        
            private void deleteData() {
        String sql = "DELETE FROM tbl_aset WHERE id_aset=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, Integer.parseInt(JOptionPane.showInputDialog("Enter ID to delete")));
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data deleted successfully");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Delete operation failed: " + e.getMessage());
        }
    }
            
    private void loadTableData() {
    String sql = "SELECT * FROM tbl_aset";
    try {
        pstmt = conn.prepareStatement(sql);
        rs = pstmt.executeQuery();

        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        
        while (rs.next()) {
            Object[] row = {
                rs.getInt("id_Aset"),
                rs.getString("Nama_Aset"),
                rs.getString("Deskripsi_Aset"),
                rs.getString("Jenis_Aset"),
                rs.getString("Status_Aset"),
                rs.getString("lokasi_Aset")
            };
            model.addRow(row);
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Failed to load data: " + e.getMessage());
    }
}
    
            
    private void deleteDataById(int idAset) {
    String sql = "DELETE FROM tbl_aset WHERE id_aset=?";
    try {
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, idAset);
        pstmt.executeUpdate();
        JOptionPane.showMessageDialog(this, "Data deleted successfully");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Delete operation failed: " + e.getMessage());
    }
}
    
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Nama_Aset = new javax.swing.JTextField();
        Deskripsi_Aset = new javax.swing.JTextField();
        Jenis_Aset = new javax.swing.JTextField();
        Status_Aset = new javax.swing.JComboBox<>();
        Lokasi_Aset = new javax.swing.JTextField();
        CREATE = new javax.swing.JToggleButton();
        READ = new javax.swing.JToggleButton();
        UPDATE = new javax.swing.JToggleButton();
        DELETE = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 255, 255));

        jLabel1.setText("Nama Aset");

        jLabel2.setText("Deskripsi Aset");

        jLabel3.setText("Jenis Aset");

        jLabel4.setText("Status Aset");

        jLabel5.setText("Lokasi Aset");

        Jenis_Aset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jenis_AsetActionPerformed(evt);
            }
        });

        Status_Aset.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Rusak", "Bagus" }));
        Status_Aset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Status_AsetActionPerformed(evt);
            }
        });

        CREATE.setText("CREATE");
        CREATE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CREATEActionPerformed(evt);
            }
        });

        READ.setText("READ");
        READ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                READActionPerformed(evt);
            }
        });

        UPDATE.setText("UPDATE");
        UPDATE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UPDATEActionPerformed(evt);
            }
        });

        DELETE.setText("DELETE");
        DELETE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DELETEActionPerformed(evt);
            }
        });

        jTable1.setBackground(new java.awt.Color(0, 153, 153));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id Aset", "Nama Aset", "Deskripsi Aset", "Jenis Aset", "Status Aset", "Lokasi Aset"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Nama_Aset)
                            .addComponent(Deskripsi_Aset)
                            .addComponent(Jenis_Aset)
                            .addComponent(Status_Aset, 0, 200, Short.MAX_VALUE)
                            .addComponent(Lokasi_Aset)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(UPDATE, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(DELETE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(CREATE, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(READ, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(Nama_Aset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(Deskripsi_Aset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(Jenis_Aset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(Status_Aset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(Lokasi_Aset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(91, 91, 91)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CREATE)
                    .addComponent(READ))
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UPDATE)
                    .addComponent(DELETE))
                .addContainerGap(103, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Jenis_AsetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jenis_AsetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Jenis_AsetActionPerformed

    private void Status_AsetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Status_AsetActionPerformed

    }//GEN-LAST:event_Status_AsetActionPerformed

    private void UPDATEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UPDATEActionPerformed
        updateData();
        loadTableData();
    }//GEN-LAST:event_UPDATEActionPerformed

    private void CREATEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CREATEActionPerformed
        createData();
        loadTableData();
    }//GEN-LAST:event_CREATEActionPerformed

    private void READActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_READActionPerformed
        readData();
        loadTableData();
    }//GEN-LAST:event_READActionPerformed

    private void DELETEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DELETEActionPerformed
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow != -1) {
            int idAset = Integer.parseInt(jTable1.getValueAt(selectedRow, 0).toString());
            

            int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this row?", "Delete Confirmation", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                deleteDataById(idAset);
                loadTableData();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select a row to delete");
        }
    }//GEN-LAST:event_DELETEActionPerformed

    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CRUD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton CREATE;
    private javax.swing.JToggleButton DELETE;
    private javax.swing.JTextField Deskripsi_Aset;
    private javax.swing.JTextField Jenis_Aset;
    private javax.swing.JTextField Lokasi_Aset;
    private javax.swing.JTextField Nama_Aset;
    private javax.swing.JToggleButton READ;
    private javax.swing.JComboBox<String> Status_Aset;
    private javax.swing.JToggleButton UPDATE;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
