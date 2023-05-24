/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DB.DB;
import Model.FrameIcon;
import Model.TableAlign;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import validation.Validation;

/**
 *
 * @author Lakshan
 */
public class ServiceType extends javax.swing.JFrame {

    DefaultTableModel dtm;
    boolean changed, firstrun;
    DecimalFormat df;

    public ServiceType() {
        initComponents();
        FrameIcon.setIcon(this);
        jTextField1.setVisible(false);
        jButton2.setVisible(false);
        df = new DecimalFormat("0.##");
        TableAlign.alignCenter(jTable1);
        dtm = (DefaultTableModel) jTable1.getModel();
        dtm.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if (e.getType() == TableModelEvent.UPDATE) {
                    changed = true;
                    addbtn.setEnabled(true);
                }
            }
        });
        loadCombos();
        if (sType.getItemCount() == 0) {
            firstrun = true;
        }
    }

    void loadCombos() {
        try {
            sType.removeAllItems();
            ResultSet r = DB.search("SELECT service_type FROM service");
            while (r.next()) {
                sType.addItem(r.getString("service_type"));
            }
        } catch (Exception e) {
        }
    }

    void loadTable(int serviceID) throws Exception {
        dtm.setRowCount(0);
        ResultSet r = DB.search("SELECT vehicle_type, price FROM service_price INNER JOIN vehicle_type ON service_price.vehicle_type_id = vehicle_type.id WHERE service_id = '" + serviceID + "'");
        while (r.next()) {
            Vector v = new Vector();
            v.add(r.getString("vehicle_type"));
            v.add(r.getString("price"));
            dtm.addRow(v);
        }
        changed = false;
        addbtn.setEnabled(false);
    }

    void loadTable() throws Exception {
        dtm.setRowCount(0);
        ResultSet r = DB.search("SELECT vehicle_type FROM vehicle_type");
        while (r.next()) {
            Vector v = new Vector();
            v.add(r.getString("vehicle_type"));
            v.add(null);
            dtm.addRow(v);
        }
        changed = true;
        addbtn.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        sType = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        addbtn = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Service Types and Prices");
        setAlwaysOnTop(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Service Type :");

        sType.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sType.setPreferredSize(new java.awt.Dimension(100, 23));
        sType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sTypeActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("+");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vehicle Type", "Charge (Rs.)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Service Charges for each Vehicle Type :");

        addbtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addbtn.setText("Save");
        addbtn.setEnabled(false);
        addbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbtnActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton3.setText("Close");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setText("Add");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(sType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jTextField1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton1)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(sType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addbtn)
                    .addComponent(jButton3))
                .addGap(14, 14, 14))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    String svc;

    private void sTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sTypeActionPerformed
        try {
            if (firstrun) {
                loadTable();
            } else {
                if (sType.getItemCount() != 0) {
                    if (changed) {
                        int ans = JOptionPane.showConfirmDialog(this, "Save Changes to Service Type '" + jTextField1.getText() + "' ?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
                        if (ans == JOptionPane.YES_OPTION) {
                            addbtnActionPerformed(null);
                        } else {
                            sType.removeItem(jTextField1.getText().trim());
                        }                        
                        jButton1.setEnabled(true);
                        jTextField1.setText(null);
                    }
                    String svc = sType.getSelectedItem().toString();
                    ResultSet r = DB.search("SELECT id FROM service WHERE service_type = '" + svc + "'");
                    int svcID;
                    if (r.next()) {
                        svcID = r.getInt("id");
                        loadTable(svcID);
                    } else {
                        loadTable();
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        svc = sType.getSelectedItem().toString();
    }//GEN-LAST:event_sTypeActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Home.getObject().setEnabled(true);
    }//GEN-LAST:event_formWindowClosing

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        dispose();
        Home.getObject().setEnabled(true);
        Home.getObject().requestFocus();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void addbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbtnActionPerformed
        try {
            boolean b = true;
            for (int i = 0; i < jTable1.getRowCount(); i++) {
                if (jTable1.getValueAt(i, 1) == null) {
                    b = false;
                    JOptionPane.showMessageDialog(this, "The price of Vehicle Type \'" + jTable1.getValueAt(i, 0).toString() + "\' is empty", "Empty Value", JOptionPane.INFORMATION_MESSAGE);
                    break;
                }
            }
            if (b) {
                ResultSet r = DB.search("SELECT id FROM service WHERE service_type = '" + svc + "'");
                int svcID;
                if (r.next()) {
                    svcID = r.getInt("id");
                } else {
                    DB.iud("INSERT INTO service(service_type) VALUES('" + svc + "')");
                    r = DB.search("SELECT id FROM service WHERE service_type = '" + svc + "'");
                    r.next();
                    svcID = r.getInt("id");
                }
                r = DB.search("SELECT service_id FROM service_price WHERE service_id = '" + svcID + "'");
                if (r.next()) {
                    for (int i = 0; i < jTable1.getRowCount(); i++) {
                        r = DB.search("SELECT id FROM vehicle_type WHERE vehicle_type = '" + jTable1.getValueAt(i, 0).toString() + "'");
                        r.next();
                        int vTypeID = r.getInt("id");
                        DB.iud("UPDATE service_price SET price = '" + df.format(Double.parseDouble(jTable1.getValueAt(i, 1).toString())) + "' WHERE service_id = '" + svcID + "' AND vehicle_type_id = '" + vTypeID + "'");
                    }
                } else {
                    for (int i = 0; i < jTable1.getRowCount(); i++) {
                        r = DB.search("SELECT id FROM vehicle_type WHERE vehicle_type = '" + jTable1.getValueAt(i, 0).toString() + "'");
                        r.next();
                        int vTypeID = r.getInt("id");
                        DB.iud("INSERT INTO service_price(service_id, vehicle_type_id, price) VALUES('" + svcID + "', '" + vTypeID + "', '" + df.format(Double.parseDouble(jTable1.getValueAt(i, 1).toString())) + "')");
                    }
                }
                changed = false;
                addbtn.setEnabled(false);
                jButton1.setEnabled(true);
                Customer.getObject().servType.removeAllItems();
                r = DB.search("SELECT service_type FROM service");
                while (r.next()) {
                    Customer.getObject().servType.addItem(r.getString("service_type"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_addbtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (jButton2.isVisible()) {
            jTextField1.setVisible(false);
            jButton2.setVisible(false);
        } else {
            jTextField1.setVisible(true);
            jButton2.setVisible(true);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            String s = jTextField1.getText().trim();
            if (!s.equals("")) {
                ResultSet r = DB.search("SELECT id FROM service WHERE service_type = '" + s + "'");
                if (r.next()) {
                    JOptionPane.showMessageDialog(this, "The Service Type you entered already exists", "Duplicate Value", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    sType.addItem(s);
                    sType.setSelectedItem(s);
                    jTextField1.setVisible(false);
                    jButton2.setVisible(false);
                    this.pack();
                    jButton1.setEnabled(false);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        Validation.validateItemName(evt, jTextField1);
    }//GEN-LAST:event_jTextField1KeyTyped

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
            java.util.logging.Logger.getLogger(ServiceType.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServiceType.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServiceType.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServiceType.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServiceType().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addbtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JComboBox<String> sType;
    // End of variables declaration//GEN-END:variables
}
